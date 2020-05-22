driver.get("https://www.scimagojr.com/journalrank.php?country=UA&page=1");
        List<Journal> journalList = new ArrayList<>();

        //...

        for (int i = 0; i < countOfPages; i++) {
            WebElement tableId = driver.findElement(By.tagName("table"));
            List<WebElement> trElements = tableId.findElements(By.xpath("./tbody/tr"));

            for (int id = 1; id <= trElements.size(); id++) {
                WebElement element = trElements.get(id);
                String title = element.findElement(By.xpath("./td[2]/a")).getText();
                String country = "Ukraine";
                journalList.add(new Journal(id, title, country));

            }
            WebElement element = driver.findElementByXPath("(//div[@class='pagination_buttons']/a)[2]");
            element.click();
        }