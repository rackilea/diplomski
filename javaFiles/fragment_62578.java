public class TimeMatcher {
    public static Matcher<RealtimeUpdate> isTimeEqual(final LocalDateTime localDateTime) {
        return new BaseMatcher<RealtimeUpdate>() {
            @Override
            public void describeTo(final Description description) {
                description.appendText("Date doesn't match with "+ localDateTime);
            }

            @Override
            public boolean matches(final Object item) {
                final RealtimeUpdate realtimeUpdate = (RealtimeUpdate) item;
                return realtimeUpdate.currentTime.isEqual(localDateTime);
            }
        };
    }
}