@After
public void browserTearDown()
{
    System.out.println("End the browser");
    driver.close();
}

@After
public void Screenshot(Scenario scenario) {
   ...

}