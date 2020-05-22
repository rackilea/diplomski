@Test
    public void checkProductFields() throws Exception {
        WebDriver driver = getDriver();

        driver.get("https://www.gumtree.com/cars/london");

        List<WebElement> productList = driver.findElements(By.xpath("//ul[@data-q='featuredresults' or @data-q='naturalresults']/li/article"));

        for (WebElement product : productList) {
            String year = product.findElement(By.xpath(".//span[@itemprop='releaseDate']")).getAttribute("innerHTML");
            String mileage = product.findElement(By.xpath(".//span[@itemprop='vehicleMileage']")).getAttribute("innerHTML");
            String fuelType = product.findElement(By.xpath(".//span[@itemprop='vehicleFuelType']")).getAttribute("innerHTML");
            String engineSize = product.findElement(By.xpath(".//span[@itemprop='vehicleEngineSize']")).getAttribute("innerHTML");

            //Assertions...
        }
    }