public static final int ONE_DAY = 24 * 60 * 60;   // 86400, not 86.4M
public static final int ONE_WEEK = ONE_DAY * 7;
public static final int TWO_WEEKS = ONE_WEEK * 2;

// ...
long days = TimeUnit.SECONDS.toDays(exp)