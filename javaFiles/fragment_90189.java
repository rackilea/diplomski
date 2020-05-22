while (true){
    WebElement button = null;
    try {
      button = driver.findElement(By.cssSelector("a[action='cancel']"));
    } catch (NoSuchElementException ex){
      break;   // button is missing, exit the loop
    }
    if (button.isDisplayed() == false) {
      break;   // button is hidden, exit the loop
    }

    driver.navigate().refresh();

    TimeUnit.SECONDS.sleep(5);
    driver.findElement(By.id("479510558845313")).sendKeys(InstagramAievx.spamusernameinput);

    driver.findElement(By.id("263795143794707")).sendKeys(InstagramAievx.spamcommentinput);

    driver.findElement(By.id("u_0_4")).sendKeys(x);
    driver.findElement(By.id("u_0_5")).click();
}