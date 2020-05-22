public static BoundedMatcher<Object, List> setBind() {
    return new BoundedMatcher<Object, List>(List.class) {
        @Override
        public void describeTo(Description description) {
            description.appendText("with item content: ");
        }

        @Override
        protected boolean matchesSafely(List list) {
            // convert every object in list to AlarmRule
            return  false;
        }
    };
}