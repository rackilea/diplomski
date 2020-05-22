public static void clickMoreDropDownElement(WebDriver driver){

    Select select=new Select(driver.findElement(By.id("filterSel")));

    //while(select.getOptions().contains("More")){

        List<WebElement> allElements = select.getOptions();

        Iterator<WebElement> itr = allElements.iterator();

        while(itr.hasNext()){

            WebElement currentElement = itr.next();


            if(currentElement.getText().equals("More...")){

                currentElement.click();

                System.out.println("Clicked More..");

                clickMoreDropDownElement(driver);
            }
        }

}