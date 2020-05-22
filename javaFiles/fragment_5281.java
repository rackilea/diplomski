public void testMethod() {
    driver.manage().window().maximize();

    WebElement firstDropDown = driver.findElement(By.id("select2-city-list-container"));
    firstDropDown.click();
    sleep();
    List<WebElement> citiesEls = getCitiesEls();
    Map<String, Map<String, List<String>>> cityData = new HashMap<>();
    for (int i = 0; i < citiesEls.size(); i++) {
        //we need to take this element every iteration, because it gets reloaded every time we open the dropdown
        WebElement cityEl = driver.findElement(By.id("select2-city-list-results")).findElements(By.xpath("//*[contains(@id,'select2-city-list-result')]")).get(i);
        String cityText = cityEl.getText();
        cityEl.click();
        sleep();

        cityData.put(cityText, getRegions());

        firstDropDown.click();
        sleep();
    }

    System.out.println(cityData);
}

private Map<String, List<String>> getRegions() {
    WebElement secondDropDown = driver.findElement(By.id("select2-region-list-container"));
    secondDropDown.click();
    sleep();
    List<WebElement> regionsEls = getRegionEls();
    Map<String, List<String>> regionData = new HashMap<>();
    for (int i = 0; i < regionsEls.size(); i++) {
        WebElement regionEl = driver.findElement(By.id("select2-region-list-results")).findElements(By.xpath("//*[contains(@id,'select2-region-list-result')]")).get(i);
        String regionText = regionEl.getText();
        regionEl.click();
        WebElement thirdDropDown = driver.findElement(By.id("select2-site-list-container"));
        thirdDropDown.click();
        List<WebElement> sitesEl = getSiteEls();
        List<String> sitesTexts = getSites(sitesEl);
        //populate region data
        regionData.put(regionText, sitesTexts);

        secondDropDown.click();
        sleep();
    }
    return regionData;
}

private List<String> getSites(List<WebElement> sitesEl) {
    List<String> sitesTexts = new ArrayList<>();
    for (WebElement siteEl : sitesEl) {
        sitesTexts.add(siteEl.getText());
    }
    return sitesTexts;
}

private List<WebElement> getSiteEls() {
    WebElement ulSites = driver.findElement(By.id("select2-site-list-results"));
    return ulSites.findElements(By.xpath("//*[contains(@id,'select2-site-list-result')]"));
}

private List<WebElement> getRegionEls() {
    return driver.findElement(By.id("select2-region-list-results")).findElements(By.xpath("//*[contains(@id,'select2-region-list-result')]"));
}

private List<WebElement> getCitiesEls() {
    return driver.findElement(By.id("select2-city-list-results")).findElements(By.xpath("//*[contains(@id,'select2-city-list-result')]"));
}