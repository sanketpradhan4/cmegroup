package com.cmegroup.palindrome.controller;

import com.cmegroup.palindrome.model.PalindromeResponse;
import com.cmegroup.palindrome.service.IPalindromeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/palindrome")
public class PalindromeController {

    @Autowired
    private IPalindromeService palindromeService;

    @PostMapping("/check")
    public ResponseEntity<PalindromeResponse> checkPalindrome(@RequestParam String username, @RequestParam String text) {
        System.out.println("username "+username+" text "+text);
        PalindromeResponse response = palindromeService.checkPalindrome(username, text);
        System.out.println(response);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}