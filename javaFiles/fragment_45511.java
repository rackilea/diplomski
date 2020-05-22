public final class DateUtility
{
    public static final DateTimeFormat MONTH_FORMAT = DateTimeFormat.getFormat("MMM");
    public static final DateTimeFormat DAY_FORMAT = DateTimeFormat.getFormat("dd");
    public static final DateTimeFormat DAY_MONTH_FORMAT = DateTimeFormat.getFormat("dd MMM");

    public static final String DASH = " - ";

    /**
     * Returns a "collapsed" date range String representing the period of time
     * between two Date parameters. Example: August 19 as a {@code startDate}
     * and August 30 as an {@code endDate} will return "19 - 30 AUG", August 28
     * as a {@code startDate} and September 7 as an {@code endDate} will return
     * "28 AUG - 07 SEP". This means if you pass this two dates which cannot
     * collapse into a shorter form, then the longer form is returned.  Years
     * are ignored, and the start and end dates are not checked to ensure we
     * are not going backwards in time (Aug 10 - July 04 is not checked).
     * 
     * @param startDate
     *            the start Date in the range.
     * @param endDate
     *            the end Date in the range.
     * @return a String representation of the range between the two dates given.
     */
    public static String collapseDate(Date startDate, Date endDate) {
        String formattedDateRange;

        // Get a comparison result to determine if the Months are the same
        String startDateMonth = MONTH_FORMAT.format(startDate);
        String endDateMonth = MONTH_FORMAT.format(endDate);

        if (startDateMonth.equals(endDateMonth))
        {
            formattedDateRange = DAY_FORMAT.format(startDate) + DASH
                    + DAY_MONTH_FORMAT.format(endDate).toUpperCase();
        }
        else
        {
            // Months don't match, split the string across both months
            formattedDateRange = DAY_MONTH_FORMAT.format(startDate).toUpperCase()
                    + DASH + DAY_MONTH_FORMAT.format(endDate).toUpperCase();
        }
        return formattedDateRange;
    }
}