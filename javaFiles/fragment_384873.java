package com.cuke;

import cucumber.api.PendingException;
import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.en.*;

public class CukeStepsA {
    @Given("^we have feature file$")
    public void we_have_feature_file() throws Throwable {
        System.out.println("execute Given step - package com.cuke");
    }
}