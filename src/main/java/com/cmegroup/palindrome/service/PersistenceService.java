package com.cmegroup.palindrome.service;

import com.cmegroup.palindrome.repository.FilePersistenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class PersistenceService {

    @Autowired
    private FilePersistenceRepository filePersistenceRepository;

    @Async
    public void persistAsync(String username, String text, Boolean isPalindrome) {
        filePersistenceRepository.save(username, text, isPalindrome);
    }
}
