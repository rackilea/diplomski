public static final String RELEASE_DATE = "2011/06/17";
private static final long MIN_TIMESTAMP;

static {
    try {
        MIN_TIMESTAMP = new SimpleDateFormat("yyyy/MM/dd").parse(RELEASE_DATE).getTime();
    } catch (ParseException e) {
        throw new AssertionError(e);
    }
}

// after the software was release and not in the future.
public static final boolean validTimestamp(long ts) {
    return ts >= MIN_TIMESTAMP && ts <= System.currentTimeMillis();
}