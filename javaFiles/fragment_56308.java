public class PersistentPeriodAsFormattedString extends
        AbstractSingleColumnUserType<Period, String,
            StringColumnPeriodFormatterMapper> {
}

public class StringColumnPeriodFormatterMapper extends
        AbstractStringColumnMapper<Period> {
    private static final PeriodFormatter FORMATTER = ...;

    @Override
    public Period fromNonNullValue(String s) {
        return FORMATTER.parsePeriod(s);
    }

    @Override
    public String toNonNullValue(Period value) {
        return value.toString(FORMATTER);
    }
}