private static class FooMatcher extends BaseMatcher<List<Foo>> {
    public String name;
    public String designation;

    public static FooMatcher matches(String name, String designation) {
        return new FooMatcher(name, designation);
    }

    private FooMatcher(String name, String designation) {
        this.name = name;
        this.designation = designation;
    }

    @Override
    public boolean matches(Object item) {
        Foo foo = (Foo) item;
        return foo.getName().equals(name) && foo.getDesignation().equals(designation);
    }

    @Override
    public void describeTo(Description description) {
        // this is a quick impl, you'll probably want to fill this in!
    }
}