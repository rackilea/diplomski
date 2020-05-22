Set<String> windowId = driver.getWindowHandles();    // get  window id of current window
    Iterator<String> itererator = windowId.iterator();   

    String mainWinID = itererator.next();
    String  newAdwinID = itererator.next();

    driver.switchTo().window(newAdwinID);
    System.out.println(driver.getTitle());
   // perform the operation on the popup driver.operations