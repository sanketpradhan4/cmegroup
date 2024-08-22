package com.cmegroup.palindrome.service;


import com.cmegroup.palindrome.model.PalindromeResponse;

public interface IPalindromeService {
    PalindromeResponse checkPalindrome(String username, String text);
}
