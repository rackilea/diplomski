for (WebElement el : listOfElem){
    String elemID = el.getAttribute("id");
    System.out.println(elemID); //1st
    Javascriptexecutor js = (Javascriptexecutor) driver;
    Object strg = js.executeScript("return(arguments[0]);",elemID);
    System.out.println(strg); //2nd
}