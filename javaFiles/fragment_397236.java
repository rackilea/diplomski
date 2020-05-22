class ListMatcher {
  public static Matcher<List<Integer>> hasAtLeastItemsGreaterThan(final int targetCount, final int lowerLimit) {
    return new TypeSafeMatcher<List<Integer>>() {

        @Override
        public void describeTo(final Description description) {
            description.appendText("should have at least " + targetCount + " items greater than " + lowerLimit);
        }

        @Override
        public void describeMismatchSafely(final List<Integer> arg0, final Description mismatchDescription) {
            mismatchDescription.appendText("was ").appendValue(arg0.toString());
        }

        @Override
        protected boolean matchesSafely(List<Integer> values) {
            int actualCount = 0;
            for (int value : values) {
                if (value > lowerLimit) {
                    actualCount++;
                }

            }
            return actualCount >= targetCount;
        }
    };
}
}