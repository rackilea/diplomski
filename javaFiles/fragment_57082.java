module org.slf4j.platform {
    // put the right module name here
    requires log4j;
    provides java.lang.System.LoggerFinder
        // put the right class name here
        with org.log4J.Log4JSystemLoggerFinder;
}