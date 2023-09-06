package com.lumu.questions;

import com.lumu.user_interfaces.WordCounterUI;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class TimesThatA {
    private TimesThatA() {
    }

    public static Question<String> wordAppears(String word) {
        return Text.of(WordCounterUI.WORD_DENSITY.of(word))
                .describedAs(" the number of times the word " + word + " is repeated. ");
    }
}
