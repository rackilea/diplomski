// get mongo db logger
Logger logger = Logger.getLogger("org.mongodb.driver");
// stop upstream log propagation
logger.setUseParentHandlers(false)
// set up handler for output to file
FileHandler fh = new FileHandler("S:/ome/path/to/your/file.log");
logger.addHandler(fh);
SimpleFormatter formatter = new SimpleFormatter();
fh.setFormatter(formatter);