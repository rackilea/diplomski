private Log log;
private Employee emp;

@Given("prepare employee")
public void given() {
    Log log = mock(Log.class);

    Employee emp = new Employee();
}

@When("save employee")
public void when() throws Exception {
    saveEmployee(emp);
}

@Then("exception should be logged")
public void then() {
    verify(log, times(1)).error("Error occured");
}