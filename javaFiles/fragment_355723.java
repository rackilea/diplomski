Thread.sleep(2000);

    List<WebElement> OptionList = driver.findElements(By.xpath("//ul[contains(@class,'ui-autocomplete')]/li/a"));
    if(OptionList.size()>=1){
        for(int i=0;i<OptionList.size();i++)
        {
            String CurrentOption = OptionList.get(i).getText();
            if(CurrentOption.equalsIgnoreCase("UDUPI")){
                System.out.println("Found the city : "+CurrentOption);
                OptionList.get(i).click();
            }
        }
    }
    else{
        System.out.println("OptionList is empty");
    }