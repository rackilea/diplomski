class ExecLogHandler extends LogOutputStream {
    private Logger log;

    public ExecLogHandler(Logger log, Level logLevel) {
        super(logLevel.toInt());
        this.log = log;
    }

    @Override
    protected void processLine(String line, int logLevel) {
        log.log(Level.toLevel(logLevel), line);
    }
}