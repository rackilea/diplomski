try {
        boolean flag = true;
        while(flag) {
            WebElement backBtn = driver.findElementByName("back");
            backBtn.click();
            Thread.sleep(1000);
            boolean isFindSettingBtn = driver.findElementsByName("setting").size() !=0;
            if(isFindSettingBtn) {
                break;
            }
        }
    }catch(Exception e) {
        e.printStackTrace();
    }