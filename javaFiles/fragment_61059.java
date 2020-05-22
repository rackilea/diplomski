public class IntegerColumnYearMonthMapper extends AbstractIntegerColumnMapper<YearMonth> {

    private static final long serialVersionUID = -9060971007814071116L;

    @Override
    public YearMonth fromNonNullString(String s) {
        return YearMonth.parse(s, DateTimeFormat.forPattern("yyyyMM"));        
    }

    @Override
    public YearMonth fromNonNullValue(Integer value) {
        return fromNonNullString(value.toString());        
    }

    @Override
    public String toNonNullString(YearMonth value) {

        return value.toString( DateTimeFormat.forPattern("yyyyMM"));
    }

    @Override
    public Integer toNonNullValue(YearMonth value) {
        return Integer.valueOf(toNonNullString(value));
    }
}