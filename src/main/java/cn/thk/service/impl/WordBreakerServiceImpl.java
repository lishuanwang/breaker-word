package cn.thk.service.impl;

import cn.thk.service.WordBreakerService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * WoldBreakerServiceImpl class
 *
 * @author lishuanwang
 * @date 2020/3/30
 */
public class WordBreakerServiceImpl implements WordBreakerService {
    private static List<String> sysDict = new ArrayList<>(16);
    static{
        sysDict.addAll(Arrays.asList("i", "like", "sam", "sung", "samsung", "mobile", "ice", "cream", "and", "man", "go"));
    }


    @Override
    public List<String> workBreaker(String matchWord, List<String> customDict, Integer needSysDict) {
        if (1 == needSysDict){
            if (CollectionUtils.isEmpty(customDict)){
                return this.getBreakResult(matchWord, sysDict, 0);
            }else{
                ArrayList<String> unionDict = new ArrayList<>();
                unionDict.addAll(sysDict);
                unionDict.addAll(customDict);
                List<String> collect = unionDict.stream().distinct().collect(Collectors.toList());
                return this.getBreakResult(matchWord, collect, 0);
            }
        }else{
            return this.getBreakResult(matchWord, customDict, 0);
        }
    }

    /**
     * 返回分词的结果
     * @param s
     * @param wordDict
     * @param offset
     * @return
     */
    private List<String> getBreakResult(String s, List<String> wordDict, int offset) {
        if (offset == s.length()) {
            List<String> res = new ArrayList<>();
            res.add("");
            return res;
        }
        List<String> resultList = new ArrayList<>();
        for (String word : wordDict) {
            if (word.equals(s.substring(offset, Math.min(s.length(), offset + word.length())))) {
                // 递归调用
                List<String> next = getBreakResult( s, wordDict, offset + word.length());
                for (String str : next) {
                    resultList.add((word + " " + str).trim());
                }
            }
        }
        return resultList;
    }

}
