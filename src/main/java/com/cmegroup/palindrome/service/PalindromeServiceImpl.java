package com.cmegroup.palindrome.service;

import com.cmegroup.palindrome.model.PalindromeResponse;
import com.cmegroup.palindrome.repository.CacheRepository;
import com.cmegroup.palindrome.util.PalindromeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PalindromeServiceImpl implements IPalindromeService {

    @Autowired
    private ValidationService validationService;

    @Autowired
    private CacheRepository cacheRepository;

    @Autowired
    private PersistenceService persistenceService;

    @Override
    public PalindromeResponse checkPalindrome(String username, String text) {
        validationService.validate(text);

        // Check cache first
        Boolean isPalindrome = cacheRepository.get(text);
        if (isPalindrome == null) {
            isPalindrome = PalindromeUtil.isPalindrome(text);
            cacheRepository.put(text, isPalindrome);

            // Persist asynchronously
            persistenceService.persistAsync(username, text, isPalindrome);
        }
        return new PalindromeResponse(username, text, isPalindrome);
    }
}
