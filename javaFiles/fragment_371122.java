List<WebElement> marks = driver.findElements(By.xpath(
                ".//table/tbody/tr/td[contains(@class ,'activityTableBody' ) and not(contains (@class ,'hidden'))]/input"));
        for (WebElement mark : marks) {
            Integer studentMark = i++ % 6;
            System.out.println(studentMark);
            mark.click();
            mark.sendKeys(Integer.toString(studentMark));
        }