public static Logger getLogger(String name) {

    Logger  logger= LogManager.getLogger(name);
    PropertyConfigurator.configure("log4j.properties"); //Path to log4j.properties as many option available in my case for testing i used static path /home/gyani/log4j.properties
    return logger;
}