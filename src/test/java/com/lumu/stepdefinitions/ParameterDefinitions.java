package com.lumu.stepdefinitions;

import com.lumu.models.KeyBordDensity;
import io.cucumber.java.Before;
import io.cucumber.java.DataTableType;
import io.cucumber.java.ParameterType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import java.util.Map;

public class ParameterDefinitions {

    @ParameterType(".*")
    public Actor actor(String actorName) {
        return OnStage.theActorCalled(actorName);
    }

    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @DataTableType
    public KeyBordDensity wordDensityEntryTransformer(Map<String, String> entry) {
        return new KeyBordDensity(
                entry.get("word"),
                entry.get("timesRepeated")
        );
    }

}
