package com.example.aspect;

import org.apache.log4j.Logger;

public aspect LoggingAspect {
    // this pointcut will match "info(Object o)" method executions where the
    // target is an instanceof Logger
    pointcut logInfoWithObject(Object obj, Logger logger) :
         execution(void info(Object)) && args(obj) && target(logger);

    // here is our advice - simply sysout something before the execution
    // proceeds and after it has finished - regardless of outcome (exception
    // or not).
    void around(Object obj, Logger logger) : logInfoWithObject(obj, logger) {
        System.out.println("Before Logger.info(Object o)");

        try {
            proceed(obj, logger);
        } finally {
            System.out.println("After Logger.info(Object o)");
        }
    }
}