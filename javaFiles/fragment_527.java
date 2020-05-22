class DateEquals extends BaseMatcher<Integer> {

    private final Date expectedValue;

    DateEquals(Date equalArg) {
        expectedValue = equalArg;
    }

    @Override
    public boolean matches(Object item) {
        Long dateTimeMillis = (Long) item;
        return dateTimeMillis.equals(toEpochMillis(expectedValue));
    }

    @Override
    public void describeTo(Description description) {
        description.appendValue(" equals to date: " + expectedValue);
    }
}