package com.cmegroup.palindrome.service;

import com.cmegroup.palindrome.exception.InvalidInputException;
import org.springframework.stereotype.Service;

@Service
public class ValidationService {

    public void validate(String text) {
        if (text == null || text.isEmpty() || text.contains(" ") || !text.matches("[a-zA-Z]+")) {
            throw new InvalidInputException("Input must be a non-empty string with no spaces or numbers.");
        }
    }
}