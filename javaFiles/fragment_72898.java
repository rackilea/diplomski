public class PolishGenitiveMonthPrinter extends SimpleDateTimePrinter {

    private static final ImmutableList<String> MONTH_NAMES =
            ImmutableList.of(
                "stycznia", "lutego", "marca", "kwietnia", "maja", "czerwca",
                "lipca", "sierpnia", "września", "października", "listopada",
                "grudnia");

    private static final int MAX_MONTH_LENGTH;

    static {
        int max = 0;
        for (String month : MONTH_NAMES) {
            if (month.length() > max) {
                max = month.length();
            }
        }
        MAX_MONTH_LENGTH = max;
    }

    @Override
    public int estimatePrintedLength() {
        return MAX_MONTH_LENGTH;
    }

    @Override
    protected String getText(ReadablePartial partial, Locale locale) {
        int month = partial.get(DateTimeFieldType.monthOfYear());
        return MONTH_NAMES.get(month - 1);
    }
}