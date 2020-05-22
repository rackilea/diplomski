static class HttpGetMatcher extends ArgumentMatcher<HttpGet> {

    private final URL expected;

    //Match by URL
    public HttpGetMatcher(URL expected) {
        this.expected = expected;
    }

    @Override
    public boolean matches(Object actual) {
        // could improve with null checks
        return ((HttpGet) actual).getURI().equals(expected);
    }

    @Override
    public void describeTo(Description description) {
        description.appendText(expected == null ? null : expected.toString());
    }
}

private static HttpGet aHttpGetWithUriMatching(URI expected){
    return argThat(new HttpGetMatcher(expected));
}