//wait for the search results. Use explicit waits and try this
    driver.findElement(By.linkText("SORT BY: MOST ACTIVE")).click();
            List<WebElement> lis=driver.findElement(By.id("sortBy-menu")).findElements(By.tagName("li"));
            for (WebElement li : lis) {
                if (li.getText().trim().equals("Most listings")) {
                    li.click();
                }
            }