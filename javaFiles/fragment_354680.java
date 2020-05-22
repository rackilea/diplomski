package com.mycompany.settingstest;

import javax.inject.Singleton;


@Singleton
public class ApplicationSettings implements SettingsInterface{

    private int firstSetting = -1234567890;
    private String secondSetting = "some default string value";
    private boolean thirdSetting = true;

    public ApplicationSettings() {

    }


    @Override
    public int getFirstSetting() {
        return this.firstSetting;
    }

    @Override
    public void setFirstSetting(int value) {
        this.firstSetting = value;
    }

    @Override
    public String getSecondSetting() {
        return this.secondSetting;
    }

    @Override
    public void setSecondSetting(String value) {
        this.secondSetting = value;
    }

    @Override
    public boolean getThirdSetting() {
        return this.thirdSetting;
    }

    @Override
    public void setThirdSetting(boolean value) {
        this.thirdSetting = value;
    }

}