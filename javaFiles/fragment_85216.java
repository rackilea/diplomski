public void naukriTest() throws InterruptedException{
    driver.get("https://www.naukri.com/nlogin/login");
    driver.findElement(By.id("usernameField")).sendKeys("validemail");
    driver.findElement(By.id("passwordField")).sendKeys("validpassword");
    driver.findElement(By.xpath("//button[@class='waves-effect waves-light btn-large btn-block btn-bold blue-btn']")).click();
    Thread.sleep(3000);
    driver.get("https://careernavigator.naukri.com/sales-executive-retail-careers-in-mahindra-and-mahindra-financial-services-15731");
    Thread.sleep(18000);
    System.out.println(driver.getTitle());

    List<WebElement> simpleTable = driver.findElements(By.xpath("(//*[name()='svg'])[2]//*[name()='text']//*[name()='tspan' and (@dy='4.40625' or @dy='3.609375')]"));
    System.out.println("size is " + simpleTable.size());
    for (int i=0;i<simpleTable.size();i++)
        System.out.println(simpleTable.get(i).getText());

}