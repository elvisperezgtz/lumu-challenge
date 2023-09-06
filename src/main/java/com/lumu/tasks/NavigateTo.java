package com.lumu.tasks;

import com.lumu.pages.WordCounterHomePage;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;

public class NavigateTo {
    public static Performable theSearchHomePage(){
        return Task.where("{0} opens the WordCounter home page",
                Open.browserOn().the(WordCounterHomePage.class));
    }
}
