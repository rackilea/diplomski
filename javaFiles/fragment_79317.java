@Test
public final void doLogin() {

    driver.findElement(By.name("userName")).sendKeys("invalidUN");
    driver.findElement(By.name("password")).sendKeys("invalidPW");
    driver.findElement(By.name("login")).click();
    System.out.println("login in progress");
}

@Test()
public final void flightFinder() {

    driver.findElement(By.xpath("//input[@type='radio' and @value='oneway']")).click();
    System.out.println("Clicked One Way");
}