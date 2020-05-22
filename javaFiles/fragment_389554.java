public class UserFilter implements Filter {

    private final Level lvl;
    private final Object userContext;

    public UserFilter(Level originalLevel, Object userContext) {
        this.lvl = originalLevel;
        this.userContext = userContext;
    }

    @Override
    public boolean isLoggable(LogRecord record) {
        if (!belongsTo(record, userContext)) {
            int levelValue = this.lvl.intValue();
            if (record.getLevel().intValue() < levelValue
                    || levelValue == Level.OFF.intValue()) {
                return false;
            }
        }
        return true;
    }


    private boolean belongsTo(LogRecord record) {
        /**
         * Insert logic here.
         */
        //return ((Integer) this.userContext) == record.getThreadId();
        return true;
    }
}