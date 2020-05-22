public static Matcher<Band> hasMembers(final Matcher<? super Iterable<Member>> matcher) {
    return new FeatureMatcher<Band, Iterable<Member>>(matcher, "a band with members", "members") {

        @Override
        protected Iterable<Member> featureValueOf(Band actual) {
            return actual.getMembers();
        }
    };
};