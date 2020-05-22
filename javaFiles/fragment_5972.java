public boolean isAlertPresent() 
{ 
    try 
    { 
        driver.switchTo().alert(); 
        return true; 
    }    
    catch (Exception e) 
    { 
        return false; 
    }    
}