package com.cmegroup.palindrome.model;

public class PalindromeResponse {

    private String username;
    private String text;
    private Boolean isPalindrome;

    public PalindromeResponse(){}
    public PalindromeResponse(String username, String text, Boolean isPalindrome) {
        this.username = username;
        this.text = text;
        this.isPalindrome = isPalindrome;
    }

    @Override
    public String toString() {
        return "PalindromeResponse{" +
                "username='" + username + '\'' +
                ", text='" + text + '\'' +
                ", isPalindrome=" + isPalindrome +
                '}';
    }

    // Getters and Setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Boolean getPalindrome() {
        return isPalindrome;
    }

    public void setPalindrome(Boolean palindrome) {
        isPalindrome = palindrome;
    }
}
