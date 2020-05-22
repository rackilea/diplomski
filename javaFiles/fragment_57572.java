public class SomeSteps extends Steps {
    @When("I store the value $value")
    public void storeValue(String value) {
        MyThreadLocal.get().setData(value);
    }
}

public class SomeOtherSteps extends Steps {
    @Then("the value is $value")
    public void checkValue(String value) {
        assertEquals(value, MyThreadLocal.get().getData());
    }
}