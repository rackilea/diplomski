String parentHandle = driver.getWindowHandle(); // get the current window handle
    System.out.println(parentHandle);               //Prints the parent window handle 
    String anchorURL = anchor.getAttribute("href"); //Assuming u are clicking on a link which opens a new browser window
    anchor.click();                                 //Clicking on this window
    for (String winHandle : driver.getWindowHandles()) { //Gets the new window handle
        System.out.println(winHandle);
        driver.switchTo().window(winHandle);        // switch focus of WebDriver to the next found window handle (that's your newly opened window)              
    }
//Now your driver works on the current new handle
//Do some work here.....
//Time to go back to parent window
    driver.close();                                 // close newly opened window when done with it
    driver.switchTo().window(parentHandle);         // switch back to the original window