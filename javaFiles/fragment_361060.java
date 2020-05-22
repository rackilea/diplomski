try{
        WebElement element = driver.findElement(By.xpath("//html/body/table[2]/form/table/tbody/tr/td/font"));
        String strngAcc = element.getText();
        System.out.println(strngAcc);
        AssertJUnit.assertEquals("Account Information Created Successfully",strngAcc);

        }
        catch(WebDriverException ex) {


          // Take **Screen Shot** here by Calling ScreenShot Capture Method
          ScreenShot.takeScreenShot(driver, "AccountTest", "createAccount");