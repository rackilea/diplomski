public String dropDownSelection(String appId, HeaderPojo hp){
        Select dropDownList = new Select(selectDropdown);
        dropDownList.selectByValue(appId);
        WebElement option = dropDownList.getFirstSelectedOption();
        String appName = option.getText();
        if(hp.getApp1() == null)
        {hp.setApp1(appName);}
        else
        {hp.setApp2(appName);}
        return appName;
    }