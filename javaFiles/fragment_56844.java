package com.jacksparrow.automation.suite.runner;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "classpath:features/functional/",
                     glue = {"com.jacksparrow.automation.steps_definitions.functional" },
                   plugin = { "pretty","json:target/cucumber-json/cucumber.json",
                            "junit:target/cucumber-reports/Cucumber.xml", "html:target/cucumber-reports"},
                   tags = { "@BAMS_Submitted_State_Guest_User" },
                   strict = false,
                   dryRun = false,
               monochrome = true)

public class RunCukeTest {
}