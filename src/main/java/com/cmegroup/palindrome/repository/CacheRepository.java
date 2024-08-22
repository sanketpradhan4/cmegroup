package com.cmegroup.palindrome.repository;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class CacheRepository {

    private final Map<String, Boolean> cache = new ConcurrentHashMap<>();

    public Boolean get(String text) {
        return cache.get(text);
    }

    public void put(String text, Boolean isPalindrome) {
        cache.put(text, isPalindrome);
    }
}
