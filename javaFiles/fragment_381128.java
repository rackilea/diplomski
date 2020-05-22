public static class SetItemMatcher extends ArgumentMatcher<Set<String>> {
    public static Set<String> setOf(Set<String> items) {
        return argThat(new SetItemMatcher(items));
    }

    private final Set<String> expected;

    public SetItemMatcher(Set<String> expected) {
        this.expected = expected;
    }

    @Override
    public boolean matches(Object argument) {
        Set<?> actual = (Set<?>) argument;
        return actual.size() == expected.size()  && containsAllItems(actual);
    }

    private boolean containsAllItems(Set<?> actual) {
        for (Object o : actual) {
            if (!expected.contains(o)) {
                return false;
            }
        }
        return true;
    }
}