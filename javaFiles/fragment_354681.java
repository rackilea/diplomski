package com.mycompany.settingstest;

import com.google.inject.AbstractModule;
import com.google.inject.Scopes;

public class ApplicationSettingsModule extends AbstractModule {

    @Override
    protected void configure() {
        //bind the service to implementation class
        bind(SettingsInterface.class).to(ApplicationSettings.class).in(Scopes.SINGLETON);//this is lazy singleton
        //bind(SettingsInterface.class).to(ApplicationSettings.class).asEagerSingleton();//this is eager one
    }
}