# MyOwnWordCounter ReadMe

## Introduction

This ReadMe file aims to explain the Big O complexity of the provided code in the `MyOwnWordCounter.java` file. The code is responsible for analyzing a text file, counting words and characters, calculating the frequency of each word, and displaying a word frequency histogram.

## Big O Complexity

Big O complexity is used to analyze the performance of an algorithm in terms of its execution time and resource usage based on the input size. Below, we will analyze key parts of the code and determine the Big O complexity of each.

### 1. `readFile` (File Reading)

```java
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
```
The complexity of this function depends on the size of the input file. If we consider the file to have n lines and m characters per line, the Big O complexity would be O(n * m) since each line is read and concatenated to the result.
### 2. `extractWords` (Word Extraction)
```java
private static String[] extractWords(String content) {
    return content.split("\\s+");
}
```
The `extractWords` function splits the content of the file into words using the split method. The Big O complexity of this function depends on the number of characters in the file's content and can be considered as O(m), where m is the total number of characters in the content.

### 3.`calculateWordFrequencies` (Word Frequency Calculation)
```java
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

```
The complexity of this function depends on the number of unique words in the input file. If there are n unique words, the complexity would be O(n) as each word is processed once.

### 4. `displayWordFrequencyHistogram` (Display Histogram)
```java
private static void displayWordFrequencyHistogram(List<Map.Entry<String, Integer>> sortedEntries) {
    for (Map.Entry<String, Integer> entry : sortedEntries) {
        System.out.println(entry.getKey() + ": " + entry.getValue());
    }
}

```
The `displayWordFrequencyHistogram` function simply iterates through the list of words and their frequencies to display them. The Big O complexity of this function is O(n), where n is the number of unique words.

### 5. `analyzeText` (Main Function)
```java
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

```
The `analyzeText` function calls all the previous functions one after another. Overall, the Big O complexity of the program would be primarily O(n * m), where n is the number of lines in the file and m is the number of characters per line. Other operations like splitting the words and calculating frequencies have lower complexity and do not dominate the program's execution time.


### Conclusion
In summary, the Big O complexity of the provided code would be mainly O(n * m), where n is the number of lines in the file, and m is the number of characters per line. Other operations have lower complexities and do not dominate the program's execution time.