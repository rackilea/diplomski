HtmlUnitDriver driver = new HtmlUnitDriver(); 
Proxy proxy = new Proxy();
proxy.setHttpProxy("42.117.1.78:3128"); 
driver.setProxySettings(proxy);
driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
driver.get("http://www.find-ip.net");
String ip = driver.findElement(By.xpath("//*[@id='ipbox']/div[1]/div[2]")).getText(); // Copia el texto del actual ip
String pais = driver.findElement(By.xpath("//*[@id='ipbox']/div[2]/div[2]")).getText(); //Copia el texto del actual Pais del proxy
System.out.println("» Ip Ficticio: " + ip +" - Country: " + pais);