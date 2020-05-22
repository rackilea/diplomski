Test(priority = 2)
    public void myfsk1 () {
        List<WebElement> elements = driver.findElements(By.className("row-title"));
        int listSize = elements.size();
        System.out.println(listSize);
        WebElement innerElement;

        for (int i = 1; i < listSize; i++) {
            driver.findElement(By.id("menu-posts-presentation"))
                  .findElement(By.xpath("./a/div[3]"))
                  .click();

            // Search again due to page refresh
            elements = driver.findElements(By.className("row-title"));
            innerElement = elements.get(i);

            System.out.println(innerElement.getText());
            Reporter.log(innerElement.getText());
            innerElement.click()

            driver.findElement(By.id("publish").click;
        }
    }