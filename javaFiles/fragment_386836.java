public static void main(String[] args) throws Exception {
    //create aioinfo0.log.
    install();
    //rename aioinfo0.log to aioinfo1.log and create aioinfo0.log.
    install();
}

private static final Logger myLogger = Logger.getLogger("info.aio");
private static volatile FileHandler fileHandler;

private static void install() throws IOException {
    FileHandler fh = fileHandler;
    if (fh != null) {
        myLogger.removeHandler(fh);
        fh.close(); //Release any file lock.
    }

    fileHandler = rotate("aioinfo%g.log", 1048576, 100, true);
    fileHandler.setFormatter(new SimpleFormatter());
    myLogger.addHandler(fileHandler);
}

private static FileHandler rotate(String pattern, int limit, int count, boolean append) throws IOException {
    if (pattern == null) {
        LogManager m = LogManager.getLogManager();
        String p = FileHandler.class.getName();
        pattern = m.getProperty(p + ".pattern");
        if (pattern == null) {
            pattern = "%h/java%u.log";
        }
    }

    new FileHandler(pattern, 0, count, false).close(); //Trigger rotate.
    return new FileHandler(pattern, limit, count, append);
}