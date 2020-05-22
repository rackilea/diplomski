class LevelFilter implements Filter {
    private Level Level;
    public LevelFilter(Level level) {
        this.level = level;
    }
    public boolean isLoggable(LogRecord record) {
        return level.intValue() < record.getLevel().intValue();
    }
}