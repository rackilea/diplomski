public void testElement(string text)
{
    try {
        driver.findElement(By.linkText(text)).isDisplayed();
        System.out.println(text + " element is displayed");
        driver.findElement(By.linkText(text)).click(); 
    } catch(NoSuchElementException e) { 
        System.out.println("--WARNING--The " + text + " element is not displayed"); 
    } finally{ 
        System.out.println("Now Add " + text + " to the Cart"); 
    }
}

testElement("I1");
testElement("I2");