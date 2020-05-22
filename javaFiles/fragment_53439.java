WebElement element=driver.findElement(By.id("ctl00_cphClaimFlow_tabcontainerClaimFlow_tabFulfillment_Shipping_ctl33_txtStreeAddress1"));
     String myInitialText=element.getAttribute("value");
     //click on radio btn
     driver.findElement(By.id("ctl00_cphClaimFlow_tabcontainerClaimFlow_tabFulfillment_Shipping_ctl33_radNewAddress")).click();
     logger.info("New Address radio button clicked");
     System.out.println("1 "+myInitialText);
    while(!myInitialText.equals("")){
        try {
            Thread.sleep(5000);
            logger.info("Thread is sleeping");
            //System.out.println("2 "+myInitialText);
            myInitialText=driver.findElement(By.id("ctl00_cphClaimFlow_tabcontainerClaimFlow_tabFulfillment_Shipping_ctl33_txtStreeAddress1")).getAttribute("value");
            //System.out.println("3 "+myInitialText);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    driver.findElement(By.id("ctl00_cphClaimFlow_tabcontainerClaimFlow_tabFulfillment_Shipping_ctl33_txtStreeAddress1")).sendKeys(td.getAddressLine1().get(0));
     logger.info("Address Line1 entered");