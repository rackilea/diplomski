String cell = "//table[@summary='Responsibilities']//tr[ contains( ., 'Base User' )]/td[2]";

String checkbox = cell + "//input";

driver.findElement( By.xpath( cell ) ).click();

WebDriverWait wait = new WebDriverWait( driver, 10 );

wait.until( ExpectedConditions.elementToBeClickabe( By.xpath( checkbox ) ) ).click();