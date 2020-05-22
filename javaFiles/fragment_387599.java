public final class DateUtil {

    private static final String DEFAULT_DATE_FORMAT = "dd-MMM-yyyy";

    private DateUtil() {
    }

    public static final String formatDate(final Date date, final String dateFormat) {
        DateFormat format = new SimpleDateFormat(dateFormat, Locale.ENGLISH);
        return format.format(date);
    }

    public static final Date formatDate(final String date) throws ParseException {
        return formatDate(date, DEFAULT_DATE_FORMAT);
    }

    public static final Date formatDate(final String date, final String dateFormat) throws ParseException {
        DateFormat format = new SimpleDateFormat(dateFormat);
        return format.parse(date);
    }
}