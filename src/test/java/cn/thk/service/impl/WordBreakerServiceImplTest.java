package cn.thk.service.impl;

import cn.thk.service.WordBreakerService;

import java.util.ArrayList;

public class WordBreakerServiceImplTest {

    private WordBreakerService wordBreakerService = new WordBreakerServiceImpl();

    @org.junit.Test
    public void workBreaker() {
        System.out.println(wordBreakerService.workBreaker("ilikeicecream", new ArrayList<String>(), 1));
        ArrayList<String> userDict = new ArrayList<String>();
        userDict.add("haha");
        System.out.println(wordBreakerService.workBreaker("ilikehaha",  userDict, 0));

        System.out.println(wordBreakerService.workBreaker("ilikeicecreamhaha", userDict, 1));
    }
}