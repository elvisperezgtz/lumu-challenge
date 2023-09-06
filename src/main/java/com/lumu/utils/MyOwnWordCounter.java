package com.lumu.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyOwnWordCounter {

    public static void main(String[] args) {
        analyzeText("input2.txt");
        analyzeText("input.txt");
    }

    public static void analyzeText(String fileName) {
        String fullPath = "src/test/resources/data/".concat(fileName);

        try {
            String content = readFile(fullPath).trim();
            String[] words = extractWords(content);

            int wordCount = countWords(words);
            int charCount = content.replaceAll("\\n", "").trim().length();

            System.out.println(wordCount + " words");
            System.out.println(charCount + " characters");

            Map<String, Integer> wordFrequencies = calculateWordFrequencies(words);
            List<Map.Entry<String, Integer>> sortedEntries = new ArrayList<>(wordFrequencies.entrySet());
            sortedEntries.sort((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()));
            displayWordFrequencyHistogram(sortedEntries);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String readFile(String fileName) throws IOException {
        StringBuilder text = new StringBuilder();
        String line;
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            while ((line = reader.readLine()) != null) {
                text.append(line).append("\n");
            }
        }
        return text.toString();
    }

    private static String[] extractWords(String content) {
        return content.split("\\s+");
    }

    private static int countWords(String[] words) {
        return words.length;
    }

    private static Map<String, Integer> calculateWordFrequencies(String[] words) {
        Map<String, Integer> wordFrequencyMap = new HashMap<>();
        for (String word : words) {
            word = word.toLowerCase().replaceAll("[^a-zA-Z]+", "");
            if (!word.isEmpty()) {
                wordFrequencyMap.put(word, wordFrequencyMap.getOrDefault(word, 0) + 1);
            }
        }
        return wordFrequencyMap;
    }

    private static void displayWordFrequencyHistogram(List<Map.Entry<String, Integer>> sortedEntries) {
        for (Map.Entry<String, Integer> entry : sortedEntries) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
