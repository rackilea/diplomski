driver.get("http://ranking-empresas.eleconomista.es/ranking_empresas_nacional.html");

driver.findElement(By.xpath("//*[@id=\"tabla-ranking\"]/table/tbody/tr[1]/td[7]/a")).click();

// wait for the data to be present
List<WebElement> cells = wait.until(
  ExpectedConditions.presenceOfAllElementsLocatedBy(
    By.xpath("//h3[.='Datos comerciales de REPSOL PETROLEO SA']/following::tbody[1]/tr/td[2]")));

String name = cells.get(0).getText(); 
String obj_soc = cells.get(1).getText();
String direcc = cells.get(2).getText();
String loc = cells.get(3).getText();
String tel = cells.get(4).getText();
String url = cells.get(7).getText();
String actividad = cells.get(8).getText();