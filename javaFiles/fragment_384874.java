package com.cuke1;

import cucumber.api.PendingException;
import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.en.*;

public class CukeStepsB {
    @When("^some glue code exists$")
    public void some_glue_code_exists() throws Throwable {
        System.out.println("execute Then step - package com.cuke1");
    }

    @Then("^those steps should not fail$")
    public void those_steps_should_not_fail() throws Throwable {
        throw new PendingException();
    }
}