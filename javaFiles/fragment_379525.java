public class TimeGreaterThanMatcher extends TypeSafeMatcher<DateTime> {
    private DateTime minTime;

    public TimeGreaterThanMatcher(DateTime minTime) {
        this.minTime = minTime;
    }

    public boolean matchesSafely(DateTime d) {
        return d != null && minTime.isBefore(d);
    }

    public StringBuffer describeTo(Description description) {
        return description.appendText("a DateTime greater than ").appendValue(minTime);
    }

    public static Matcher<DateTime> timeGreaterThan(DateTime minTime) {
      return new TimeGreaterThanMatcher(minTime);
    }
}