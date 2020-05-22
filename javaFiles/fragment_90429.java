@And("^User captures Origin (.*)$")              
   public void User_captures_Origin(String origin) throws Exception{ 

    // click on drop down button
    WebElement DropdownButton = driver.findElement(By.xpath("//button[@data-id='ContentPlaceHolder1_ddlOrigin']"));
    DropdownButton.click();

    // select a drop down option
     WebElement DropdownOption= driver.findElement(By.xpath("//ul/li/a/span[text()="+origin+"]"));
     DropdownOption.click();
    }