//Set Screen Brightness
    public boolean setScreenBrightness(float sBrightness){
        if(sBrightness>=0){
            WindowManager.LayoutParams wMLayout = getWindow().getAttributes();
            wMLayout.screenBrightness = sBrightness; //Modify Brightness
            getWindow().setAttributes(wMLayout); //Apply changes
            return true;
        }else
        {
            return false;
        }
    }