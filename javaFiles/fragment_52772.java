verify(mock, times(1)).someMethod(argThat(personNamed("Bob")));

Matcher<Person> personNamed(final String name) {
    return new TypeSafeMatcher<Person>() {
        public boolean matchesSafely(Person item) {
            return name.equals(item.getName());
        }
        public void describeTo(Description description) {
            description.appendText("a Person named " + name);
        }
    };
}