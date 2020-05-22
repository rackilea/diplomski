private static ReadParameterFile config;
private static Logger log;
static {
    config = new ReadParameterFile();
    System.setProperty("logDir",config.getProtokollDirProtokoll());
    System.setProperty("logFilename", config.getProtokollDateinameProtokoll());
    log = LogManager.getLogger(main.class);
}