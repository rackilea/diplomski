public class SyncLogLevel extends Level{

    private static final long serialVersionUID = 1L;

    public SyncLogLevel(int level, String levelStr, int syslogEquivalent) {
        super(level, levelStr, syslogEquivalent);
    }
    public static SyncLogLevel toLevel(int val, Level defaultLevel) {
        return DISASTER;
    }

    public static SyncLogLevel toLevel(String sArg, Level defaultLevel) {
        return DISASTER;
    }
    public static final SyncLogLevel DISASTER = new SyncLogLevel(60000, "DISASTER", 0);

}