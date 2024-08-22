package com.cmegroup.palindrome.repository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class FilePersistenceRepository {

    private final String filePath;

    public FilePersistenceRepository(String filePath) {
        this.filePath = filePath;
    }

    public synchronized void save(String username, String text, Boolean isPalindrome) {
        //System.out.println("filePath "+filePath);
        try (FileWriter writer = new FileWriter(filePath, true)) {
            writer.write(username + "," + text + "," + isPalindrome + "\n");
        } catch (IOException e) {
            throw new RuntimeException("Error saving to file", e);
        }
    }

    public Map<String, Boolean> load() {
        Map<String, Boolean> cache = new ConcurrentHashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                cache.put(parts[1], Boolean.valueOf(parts[2]));
            }
        } catch (IOException e) {
            throw new RuntimeException("Error loading from file", e);
        }
        return cache;
    }
}
