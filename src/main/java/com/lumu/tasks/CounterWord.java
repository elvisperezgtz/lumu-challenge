package com.lumu.tasks;

import com.lumu.user_interfaces.WordCounterUI;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.conditions.Check;

public class CounterWord implements Task {

    private String aTextOrParagraph;
    private boolean clickOnUndo;
    private boolean clickOnRedo;
    private boolean clickOnClear;

    @Override
    @Step("{0} ")
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                Enter.theValue(aTextOrParagraph).into(WordCounterUI.BOX),
                Check.whether(clickOnClear).andIfSo(Click.on(WordCounterUI.CLEAR)),
                Check.whether(clickOnUndo).andIfSo(Click.on(WordCounterUI.UNDO)),
                Check.whether(clickOnRedo).andIfSo(Click.on(WordCounterUI.REDO))
        );
    }

    public static CounterWord with() {
        return Tasks.instrumented(CounterWord.class);
    }

    public CounterWord aTextOrParagraph(String aTextOrParagraph) {
        this.aTextOrParagraph = aTextOrParagraph;
        return this;
    }

    public CounterWord clickOnClear(boolean clickOnClear) {
        this.clickOnClear = clickOnClear;
        return this;
    }

    public CounterWord clickOnUndo(boolean clickOnUndo) {
        this.clickOnUndo = clickOnUndo;
        return this;
    }

    public CounterWord clickOnRedo(boolean clickOnRedo) {
        this.clickOnRedo = clickOnRedo;
        return this;
    }

}
