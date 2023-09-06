package com.lumu.models;

public class KeyBordDensity {
    private String word;
    private String timesRepeated;

    public KeyBordDensity(String word, String timesRepeated) {
        this.word = word;
        this.timesRepeated = timesRepeated;
    }

    public String getWord() {
        return word;
    }

    public String getTimesRepeated() {
        return timesRepeated;
    }
}

