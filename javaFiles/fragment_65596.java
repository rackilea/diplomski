// not visible from the outside
private static final long MILLISECONDS_IN_A_MINUTE = 1000L * 60 * 60;

public static Date addMinutes(Date d, int amount) {
    return addMillis(d, MILLISECONDS_IN_A_MINUTE * amount);
}

// not visible from the outside
private static Date addMillis(Date d, long amount) {
    return new Date(d.getTime() + amount);
}