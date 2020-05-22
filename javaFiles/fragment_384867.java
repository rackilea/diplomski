package com.cuke;

import cucumber.api.PendingException;
import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.en.*;

public class CukeSteps {
    @Given("^we have feature file$")
    public void we_have_feature_file() throws Throwable {
        System.out.println("execute Given step");
    }

    @When("^some glue code exists$")
    public void some_glue_code_exists() throws Throwable {
        System.out.println("execute Then step");
    }

    @Then("^those steps should not fail$")
    public void those_steps_should_not_fail() throws Throwable {
        throw new PendingException();
    }
}