package com.cmegroup.palindrome.config;
import com.cmegroup.palindrome.repository.CacheRepository;
import com.cmegroup.palindrome.repository.FilePersistenceRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public CacheRepository cacheRepository() {
        return new CacheRepository();
    }

    @Bean
    public FilePersistenceRepository filePersistenceRepository() {
        return new FilePersistenceRepository("palindromes.txt");
    }
}