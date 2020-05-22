package com.your.package;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class YourServletContextListener implements ServletContextListener {

    public void contextInitialized(ServletContextEvent event) {
        // Place here the code to run once the application is ready 
    }

    public void contextDestroyed(ServletContextEvent event) {
        // Place here the code to run just before the application goes down
    }

}