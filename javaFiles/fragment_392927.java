//set javascript enabled to true
HtmlUnitDriver driver = new HtmlUnitDriver(true);

//to set logging off....
LogFactory.getFactory().setAttribute("org.apache.commons.logging.Log","org.apache.commons.logging.impl.NoOpLog");
java.util.logging.Logger.getLogger("com.gargoylesoftware.htmlunit").setLevel(Level.OFF);
java.util.logging.Logger.getLogger("org.apache.commons.httpclient").setLevel(Level.OFF);

// navigate to the page
driver.get("https://kickass.to/australian-aria-top-50-singles-13-10-2014-t9702189.html");
driver.executeScript("javascript:getFiles('52261EB9480EDFD83B5B85C8C4817D28F3AE0C95', 1);","");
//this is displayed only after executing the javascript
System.out.println(driver.getPageSource().contains("Australian ARIA Top 50 Singles 13.10.2014.pdf"));
System.out.println(driver.getPageSource().contains("47. Sheppard - Geronimo.mp3"));
//System.out.println(driver.getPageSource());
driver.quit();