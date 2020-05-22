package com.mycompany.settingstest;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;

public class MainApplication {

    public static void main(String[] args) {

        Injector applicationSettingsInjector = Guice.createInjector(new ApplicationSettingsModule());

        SettingsInterface applicationSettings = applicationSettingsInjector.
                                         getInstance(SettingsInterface.class);

        System.out.println(" ******* Main Application *******");
        System.out.println(" Initial setting values ");

        System.out.println("first setting: " + applicationSettings.getFirstSetting());
        System.out.println("second setting: " + applicationSettings.getSecondSetting());
        System.out.println("third setting: " + applicationSettings.getThirdSetting());
        System.out.println(" ******* ******* *******");


        System.out.println(" ******* We're changing settings *******");        
        applicationSettings.setFirstSetting(789);
        applicationSettings.setSecondSetting("another custom string");
        applicationSettings.setThirdSetting(false);

        System.out.println(" Settings were changed. Check changes below: ");
        System.out.println("first setting: " + applicationSettings.getFirstSetting());
        System.out.println("second setting: " + applicationSettings.getSecondSetting());
        System.out.println("third setting: " + applicationSettings.getThirdSetting());
        System.out.println(" ******* ******* *******");

        System.out.println(" Now composing the application component and injecting application settings to it");        
        ApplicationComponent applicationComponent = applicationSettingsInjector.getInstance(ApplicationComponent.class);
        applicationComponent.execute();
    }
}

class ApplicationComponent {

    @Inject
    private SettingsInterface applicationSettings;


    public ApplicationComponent() {

    }

    public void execute() {

        System.out.println(" ******* Application component *******");
        System.out.println("Application settings instance is already injected");

        System.out.println("first setting: " + applicationSettings.getFirstSetting());
        System.out.println("second setting: " + applicationSettings.getSecondSetting());
        System.out.println("third setting: " + applicationSettings.getThirdSetting());
        System.out.println(" ******* ******* *******");        

    }
}