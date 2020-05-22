String wantedOption = "wanted KPI";

// click the down arrow to expand options
driver.findElement(By.cssSelecor("div.Select.kpi-select span.Select-arrow")).click();


// select wanted KPT
driver.findElement(By.cssSelector("div.Select.kpi-select div.Select-menu"))
    .findElement(By.xpath(String.format(".//div[text()='%s']", wantedOption)))
    .click();