public static final SimpleDateFormat SDF_DATE = new SimpleDateFormat("yyyy MMM dd");
    public static final SimpleDateFormat SDF_HOUR = new SimpleDateFormat("HH:mm:ss");

    public String getDateAddedToString() {
            return DateFormatters.SDF_DATE.format(dateAdded.getTime());
    }