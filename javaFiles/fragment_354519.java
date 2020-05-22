final class FooTest {

    static final class Foo {

        final int val;
        final String name;

        // all args constructor
    }

    // custom matcher
    static final class FoosHasSameValues extends TypeSafeMatcher<List<Foo>> {

        private final Set<String> names;

        // all args constructor

        FoosHasSameValues(final String... names) {
            this(new HashSet<>(Arrays.asList(names)));
        }

        @Override
        protected boolean matchesSafely(final List<Foo> items) {
            final List<Integer> values = items.stream()
                // filter only items with specified names
                .filter(i -> this.names.contains(i.name))
                // select only values
                .map(i -> i.val)
                .collect(Collectors.toList());
            if (values.size() != this.names.size()) {
                // matching failed if list doesn't contains all
                // needed items with names
                return false;
            }
            // check https://stackoverflow.com/a/29288616/1723695
            return values.stream().distinct().limit(2).count() <= 1;
        }

        @Override
        public void describeTo(final Description description) {
            description.appendText("has items [")
                .appendValue(String.join(", ", this.names))
                .appendText("] with same values");
        }
    }

    @Test
    void testMatchers() throws Exception {
        MatcherAssert.assertThat(
            Arrays.asList(
                new Foo("first", 1),
                new Foo("second", 1),
                new Foo("third", 2)
            ),
            new FoosHasSameValues("first", "second")
        );
    }
}