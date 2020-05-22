@Test(expected = org.openqa.selenium.TimeoutException.class)
public void TESTING_IPS_THIS_SHOULD_TRIGGER_ALERT_AND_BLACKHOLE() {
    driver.get("http://testmyids.com");
    //I would like to do a simple assert here that timeout is true;

}