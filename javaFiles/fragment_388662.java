String filePattern = " fileName%.log";
int limit = 1000 * 1000; // 1 Mb
int numLogFiles = 3;
FileHandler fh = new FileHandler(filePattern, limit, numLogFiles);

// Add to logger
Logger logger = Logger.getLogger(MyClass.class.getPackage().getName());
logger.addHandler(fh);