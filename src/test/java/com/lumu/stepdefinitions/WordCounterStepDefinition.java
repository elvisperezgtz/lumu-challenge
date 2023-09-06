package com.lumu.stepdefinitions;

import com.lumu.models.KeyBordDensity;
import com.lumu.questions.TimesThatA;
import com.lumu.tasks.CounterWord;
import com.lumu.tasks.NavigateTo;
import com.lumu.user_interfaces.WordCounterUI;
import com.lumu.utils.StringsUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.util.ArrayList;
import java.util.List;

import static com.lumu.user_interfaces.WordCounterUI.*;
import static java.time.Duration.ofSeconds;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.containsText;
import static net.serenitybdd.screenplay.waits.WaitUntil.the;
import static org.openqa.selenium.support.ui.ExpectedConditions.textToBePresentInElement;

public class WordCounterStepDefinition {

    @Given("{actor} is on the word counter home page")
    public void elvisIsOnTheWordCounterHomePage(Actor actor) {
        actor.wasAbleTo(NavigateTo.theSearchHomePage());
    }

    @When("{actor} wants to use the word counter functionality with the following paragraph")
    public void heWantsToUseTheWordCounterFunctionalityWithTheFollowingParagraph(Actor actor, String paragraph) {
        actor.attemptsTo(Enter.theValue(paragraph).into(WordCounterUI.BOX));
    }

    @Then("{actor} should be able to see the text {string}")
    public void heShouldBeAbleToSeeTheText(Actor actor, String countResult) {
        actor.attemptsTo(
                the(COUNT_RESULT.of(countResult), containsText(countResult)).forNoMoreThan(ofSeconds(10))
        );
        actor.attemptsTo(Ensure.that(COUNT_RESULT.of(countResult)).text().isEqualTo(countResult));
    }

    @Then("{actor} should be able to see that the sum of the all keyword density is 100%")
    public void heShouldBeAbleToSeeThatTheSumOfTheAllKeywordDensityIs100(Actor actor) {

        List<String> wordsDensityList = new ArrayList<>();
        actor.attemptsTo(WaitUntil.the(KEYWORD.of("test"), WebElementStateMatchers.isCurrentlyVisible()));
        for (WebElementFacade words : WordCounterUI.KEYWORDS_DENSITY_RESULT.resolveAllFor(actor)) {
            wordsDensityList.add(words.getText());
        }
        List<Integer> wordsResultList = StringsUtils.extractNumbersFromStrings(wordsDensityList);
        int percent = 0;
        for (int number : wordsResultList) {
            percent = percent + number;
        }

        actor.attemptsTo(Ensure.that(percent).isEqualTo(100));
    }

    @Then("{actor} should see that the site displays the three most repeated words as:")
    public void heShouldSeeThatTheSiteDisplaysTheThreeMostRepeatedWordsAs(Actor actor, List<KeyBordDensity> wordDensityList) {
        String keywordReference = wordDensityList.get(0).getWord();
        actor.attemptsTo(WaitUntil.the(KEYWORD.of(keywordReference), WebElementStateMatchers.isCurrentlyVisible()));
        for (KeyBordDensity wordDensity : wordDensityList) {
            actor.attemptsTo(
                    Ensure.that(TimesThatA.wordAppears(wordDensity.getWord())).isEqualTo(wordDensity.getTimesRepeated())
                            .withReportedError("Expected word: " + wordDensity.getWord() + " is not in the Keyword density list")
            );
        }
    }

    @Then("{actor} should see display the word count correctly as {string}")
    public void heShouldSeeDisplayTheWordCountCorrectlyAs(Actor actor, String wordCount) {
        actor.attemptsTo(
                the(textToBePresentInElement(WORDS.resolveFor(actor), wordCount)),
                Ensure.that(WORDS).text().isEqualTo(wordCount));
    }

    @Then("{actor} should see display the number of characters correctly as {string}")
    public void heShouldSeeDisplayTheNumberOfCharactersCorrectlyAs(Actor actor, String countCharacter) {
        actor.attemptsTo(
                the(textToBePresentInElement(CHARACTERS.resolveFor(actor), countCharacter)),
                Ensure.that(CHARACTERS).text().isEqualTo(countCharacter));
    }

    @When("{actor} wants to use the buttons clear, undo and redo in the same operation")
    public void heWantsToUseTheButtonsClearUndoAndRedoInTheSameOperation(Actor actor, String paragraph) {
        actor.attemptsTo(
                CounterWord
                        .with()
                        .aTextOrParagraph(paragraph)
                        .clickOnClear(true)
                        .clickOnUndo(true)
                        .clickOnRedo(true)
        );

    }

    @Then("{actor} should see the counter with the text : {string}")
    public void heShouldSeeTheCounterWithTheText(Actor actor, String textCounter) {

        actor.attemptsTo(
                the(textToBePresentInElement(COUNT_RESULT.of(textCounter).resolveFor(actor), textCounter)),
                Ensure.that(COUNT_RESULT.of(textCounter)).text().isEqualTo(textCounter));
    }

    @When("{actor} enters text containing special characters such as {string}")
    public void heEntersTextContainingSpecialCharactersSuchAs(Actor actor, String paragraph) {
        actor.attemptsTo(
                CounterWord
                        .with()
                        .aTextOrParagraph(paragraph)

        );
    }
}
