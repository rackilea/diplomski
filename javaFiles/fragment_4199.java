/**
     * Difference between Filetime epoch and Unix epoch (in ms).
     */
    private static final long FILETIME_EPOCH_DIFF = 11644473600000L;

    /**
     * One millisecond expressed in units of 100s of nanoseconds.
     */
    private static final long FILETIME_ONE_MILLISECOND = 10 * 1000;

    public static long filetimeToMillis(final long filetime) {
        return (filetime / FILETIME_ONE_MILLISECOND) - FILETIME_EPOCH_DIFF;
    }

    public static long millisToFiletime(final long millis) {
        return (millis + FILETIME_EPOCH_DIFF) * FILETIME_ONE_MILLISECOND;
    } 

SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
            String dateInString = "01-07-2017 10:20:56";
            Date date = sdf.parse(dateInString);
            final long dd = date.getTime();
            Attribute accountExpires = new BasicAttribute("accountExpires", Long.toString(millisToFiletime(dd)));