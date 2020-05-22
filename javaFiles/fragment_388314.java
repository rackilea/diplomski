public static long getLocalToUtcDelta() {
    Calendar local = Calendar.getInstance();
    local.clear();
    local.set(1970, Calendar.JANUARY, 1, 0, 0, 0);
    return local.getTimeInMillis();
}

public static long converLocalTimeToUtcTime(long timeSinceLocalEpoch) {
    return timeSinceLocalEpoch + getLocalToUtcDelta();
}