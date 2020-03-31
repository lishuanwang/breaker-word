package cn.thk.terminal;

import cn.thk.constants.SystemMsgEnum;
import cn.thk.service.WordBreakerService;
import cn.thk.service.impl.WordBreakerServiceImpl;
import org.apache.commons.lang.StringUtils;

import java.util.*;

/**
 * WordBreakerTerminal class
 *
 * @author lishuanwang
 * @date 2020/3/31
 */
public class WordBreakerTerminal {


    public static WordBreakerService wordBreakerService = new WordBreakerServiceImpl();

    public static void main(String[] args) {
        while(true){
            System.out.println(SystemMsgEnum.SYSTEM_COMMAND_MSG.getMsg());
            Scanner commandSc = new Scanner(System.in);
            int i = 0;
            try{
                i = commandSc.nextInt();
                if (4 == i){
                    System.exit(-1);
                }
            }catch (InputMismatchException misMatch){
                System.out.println(SystemMsgEnum.SYSTEM_COMMAND_ERROR.getMsg());
            }
            System.out.println(SystemMsgEnum.USER_BREAKER_MSG.getMsg());
            Scanner needBreakWord = new Scanner(System.in);
            String s = needBreakWord.nextLine();
            switch (i){
                case 1:  breakWordUseSysDict(s); break;
                case 2:  breakWordUseUserDict(s, 0); break;
                case 3:  breakWordUseUserDict(s, 1);break;
                default: System.out.println(SystemMsgEnum.BREAK_COMMAND_ERROR.getMsg()); break;
            }
        }

    }

    private static List<String> getUserDict(){
        System.out.println("请输入您定义的词典,以逗号分隔");
        Scanner dictScanner = new Scanner(System.in);
        String[] split = new String[16];
        try{
            String s = dictScanner.nextLine();
            split = StringUtils.split(s, ",");
        }catch (Exception ex){
            System.out.println("您定义的用户字典有误，请检查后重新输入");
        }
        ArrayList<String> stringArrayList = new ArrayList<>(Arrays.asList(split));
        System.out.println("您定义的词典是："+stringArrayList);
        return stringArrayList;
    }

    private static void breakWordUseSysDict(String needBreakWord){
        List<String> strings = wordBreakerService.workBreaker(needBreakWord, new ArrayList<>(), 1);
        System.out.println("匹配的结果是："+StringUtils.join(strings, " "));
    }



    private static void breakWordUseUserDict(String needBreakWord, Integer needSysDict){
        List<String> userDict = getUserDict();
        List<String> result = wordBreakerService.workBreaker(needBreakWord, userDict, needSysDict);
        System.out.println("匹配的结果是："+StringUtils.join(result, " "));
    }


}
