package org.paulvargas.test;

import java.io.File;
import java.util.logging.Logger;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public final class TestListener implements ServletContextListener {

    private static final Logger LOG = Logger
            .getLogger(ServletContextListener.class.getName());

    public TestListener() {
        LOG.info("LOG directory:" + System.getProperty("catalina.base")
                + File.separator + "logs");
    }

    public void contextInitialized(ServletContextEvent evt) {
        LOG.info("TestListener initialized: " + evt);
    }

    public void contextDestroyed(ServletContextEvent evt) {
        LOG.info("TestListener destroyed: " + evt);
    }

}