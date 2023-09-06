package com.lumu.user_interfaces;

import net.serenitybdd.screenplay.targets.Target;

public class WordCounterUI {
    private WordCounterUI() {
    }

    public static final Target TITLE = Target.the("Page title")
            .locatedBy("");

    public static final Target BOX = Target.the("Box")
            .locatedBy("#box");

    public static final Target COUNT_RESULT = Target.the("Count result with text: {0}")
            .locatedBy("//span[contains(text(),'{0}')]");

    public static final Target WORDS = Target.the("Words count")
            .locatedBy("#word_count");

    public static final Target CHARACTERS = Target.the("Characters count")
            .locatedBy("#character_count");

    public static final Target KEYWORDS_DENSITY_RESULT = Target.the("List of words density")
            .locatedBy("//a[@class='list-group-item']/child::span[@class='badge']");

    public static final Target KEYWORD = Target.the("Keyword {0}")
            .locatedBy("//a[@class='list-group-item']/span[@class='word' and text()='{0}']");

    public static final Target WORD_DENSITY = Target.the("Word density of keywords {0}")
            .locatedBy("//a[@class='list-group-item']/span[@class='word' and text()='{0}']/preceding-sibling::span[@class='badge']");

    public static final Target LIST_OF_KEYWORDS = Target.the("List of keyboard that appears on the Keyboard density")
            .locatedBy("//a[@class='list-group-item']/child::span[@class='word']");
    public static final Target UNDO = Target.the("Undo button")
            .locatedBy("#undo-btn");
    public static final Target REDO = Target.the("Redo button")
            .locatedBy("#redo-btn");
    public static final Target CLEAR = Target.the("Clear button")
            .locatedBy("#clear-btn");


}
