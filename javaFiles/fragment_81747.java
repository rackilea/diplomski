package com.waze.rr_logger;

import org.apache.log4j.Logger;
import org.apache.log4j.BasicConfigurator;

public class SiftExampleLog4j {

    static org.apache.log4j.Logger logger = Logger
            .getLogger(SiftExampleLog4j.class);

    public void log() {
        // Set up a simple configuration that logs on the console.
        BasicConfigurator.configure(); // You have missed to add this

        org.apache.log4j.MDC.put("session_id", "MyGooApp");

        logger.error("example1");

        org.apache.log4j.MDC.put("session_id", "MyFooApp");

        logger.error("example2");
    }
}