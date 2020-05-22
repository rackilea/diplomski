WebElement elmn = Login.driver.findElements
                        (By.xpath("Xpath to identify element without the attribute"))
if (elmn.getAttribute("style").equals("display: none;"))
    exit;
else 
   Assert.fail()