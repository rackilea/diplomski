public static void fbSearch() {
    System.setProperty("webdriver.chrome.driver", "D:\\Galen\\chromedriver.exe");
    WebDriver driver = new ChromeDriver();
    driver.get("http://www.facebook.com");
    driver.findElement(By.name("email")).sendKeys("phystem");
    driver.findElement(By.name("pass")).sendKeys("yyy");
    driver.findElement(By.id("loginbutton")).click();
    waitForPageLoaded(driver);
    fbPostSearch(driver, "True Story", 20);//timeOut in Mins
}

public static Boolean fbPostSearch(WebDriver driver, String postContent, int timeOutInMins) {
    Set<WebElement> allPosts = new HashSet<>();
    int totalTime = timeOutInMins * 60000; // in millseconds
    long startTime = System.currentTimeMillis();
    boolean timeEnds = false;
    while (!timeEnds) {
        List<WebElement> posts = getPosts(driver);
        posts.removeAll(allPosts);//to remove old posts as we already searched it
        allPosts.addAll(posts);//append new posts to all posts
        for (WebElement post : posts) {
            String content = post.getText();
            if (content.contains(postContent)) {
                //this is our element
                System.out.println("Found");
                new Actions(driver).moveToElement(post).build().perform();
                ((JavascriptExecutor) driver).executeScript("arguments[0].style.outline='2px solid #ff0';", post);
                return true;
            }
        }
        scrollToBottom(driver);
        waitForPageLoaded(driver);
        timeEnds = (System.currentTimeMillis() - startTime >= totalTime);
    }
    System.out.println("Not Found");
    return false;
}

public static List<WebElement> getPosts(WebDriver driver) {
    //finding Posts which has textContent coz some posts are image only
    return driver.findElements(By.cssSelector("div._4-u2.mbm._5v3q._4-u8 div._5pbx.userContent"));
}

private static void scrollToBottom(WebDriver driver) {
    long longScrollHeight = (Long) ((JavascriptExecutor) driver).executeScript("return Math.max("
            + "document.body.scrollHeight, document.documentElement.scrollHeight,"
            + "document.body.offsetHeight, document.documentElement.offsetHeight,"
            + "document.body.clientHeight, document.documentElement.clientHeight);"
    );
    ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, " + longScrollHeight + ");");
}

public static void waitForPageLoaded(WebDriver driver) {
    ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
        @Override
        public Boolean apply(WebDriver driver) {
            return ((JavascriptExecutor) driver).executeScript(
                    "return document.readyState").equals("complete");
        }
    };
    WebDriverWait wait = new WebDriverWait(driver, 20);
    wait.until(expectation);
}