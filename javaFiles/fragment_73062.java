WebDriver driver = new ChromeDriver();
WebDriverWait wait = new WebDriverWait(driver, 10);

driver.get("http://ranking-empresas.eleconomista.es/ranking_empresas_nacional.html");

driver.findElement(By.xpath("//*[@id=\"tabla-ranking\"]/table/tbody/tr[1]/td[7]/a")).click();

// wait for the data to be present
wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("business-profile")));

String name = driver.findElement(By.xpath("//*[@id=\"business-profile\"]/div[17]/div[1]/div[2]/table/tbody/tr[1]/td[2]")).getText(); 
String obj_soc = driver.findElement(By.xpath("//*[@id=\"business-profile\"]/div[17]/div[1]/div[2]/table/tbody/tr[2]/td[2]")).getText();
String direcc = driver.findElement(By.xpath("//*[@id=\"business-profile\"]/div[17]/div[1]/div[2]/table/tbody/tr[3]/td[2]")).getText();
String loc = driver.findElement(By.xpath("//*[@id=\"business-profile\"]/div[17]/div[1]/div[2]/table/tbody/tr[4]/td[2]")).getText();
String tel = driver.findElement(By.xpath("//*[@id=\"business-profile\"]/div[17]/div[1]/div[2]/table/tbody/tr[5]/td[2]")).getText();
String url = driver.findElement(By.xpath("//*[@id=\"business-profile\"]/div[17]/div[1]/div[2]/table/tbody/tr[8]/td[2]")).getText();
String actividad = driver.findElement(By.xpath("//*[@id=\"business-profile\"]/div[17]/div[1]/div[2]/table/tbody/tr[9]/td[2]")).getText();

volcado.print(name+" "+obj_soc+" "+direcc+" "+loc+" "+tel+" "+url+" "+actividad);      
volcado.close();