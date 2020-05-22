// open up the dropdown
wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='cho‌​sen_motivos_investimentos_chosen']/a"))).click();

WebElement dropDespesa = driver.findElement(By.xpath(".//*[@id='chosen_motivos_investimentos_chosen']/div[1]/ul[1]"));

dropDespesa.findElement(By.xpath(".//li[. = '" + despesa + "']")).click();