public void verifyErrorMsgforInvalidUserTransPosting(
{
    String errorMSG="You dont have permission to create transaction using this ID";
    Boolean isPresent = driver.findElements(By.xpath("html/div/.....").size() > 0;

    if(!isPresent)
    {
        System.out.println("Failed to find element");
        return;
    }

    String errorMSGSYS = driver.findElement(By.xpath("html/div/.....").getText();       
    if(errorMSGSYS.equals(errorMSG))
    {
        System.out.println("System didnt allowed user to post the Transaction");
        report.updateTestLog("Verify System is NOT allowing user to post transaction for an invalid user", "System didnt allowed user to post the Transaction", Status.SCREENSHOT);
    }
    else
    {
        System.out.println("System is allowing user to post the Transaction which is NOT expected behavior");
        report.updateTestLog("Verify System is NOT allowing user to post transaction for an invalid user", "System is allowing user to post the Transaction which is NOT expected behavior", Status.FAIL);
    }
}