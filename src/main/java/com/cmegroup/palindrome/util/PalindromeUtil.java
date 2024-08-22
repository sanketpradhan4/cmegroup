package com.cmegroup.palindrome.util;
public class PalindromeUtil {

    public static boolean isPalindrome(String text) {
        StringBuilder sb = new StringBuilder(text);
        return sb.reverse().toString().equals(text);
    }
}
