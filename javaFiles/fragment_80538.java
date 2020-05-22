public class TrustedTime {
    private static long internetTime;
    private static long updateTime;

    /** this needs to happen once */
    public static void updateInternetTime(long time) {
        updateTime = SystemClock.elapsedRealtime();
        internetTime = time;
    }

    public static long currentTimeMillis() {
        long sinceUpdate = SystemClock.elapsedRealtime() - updateTime;
        return internetTime + sinceUpdate;
    }
}