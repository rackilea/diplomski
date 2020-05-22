String configFilename = log4jConfigFile.getAbsolutePath();
DOMConfigurator.configure(configFilename);

// set your appenders programmatically here
// ...

MyXMLWatchdog watchDogThread = new MyXMLWatchdog(configFilename);
watchDogThread.setDelay(100000L);
watchDogThread.start();