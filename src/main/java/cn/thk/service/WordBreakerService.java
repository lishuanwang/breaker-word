package cn.thk.service;

import java.util.List;

public interface WordBreakerService {

    List<String> workBreaker(String matchWord, List<String> customDict, Integer needSysDict);
}
