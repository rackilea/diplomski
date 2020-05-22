@Test
public void removesMultipleParametersFromQuery() throws Exception {
    String result = removeParameters("foo=fooValue&zee=lalal&bar=barValue&phleem=phleemValue", "foo", "bar");
    assertThat(result, is("zee=lalal&phleem=phleemValue"));
}

private String removeParameters(String query, final String...parameterNames) {
    List<String> list = newArrayList(query.split("&"));
    return Joiner.on("&").join(filter(list, startsWithAnyOf(parameterNames)));
}

private Predicate<String> startsWithAnyOf(final String[] parameterNames) {
    return new Predicate<String>() {
        public boolean apply(String s) {
            return !Iterables.any(newArrayList(parameterNames), isPrefixOf(s));
        }
    };
}

private Predicate<String> isPrefixOf(final String string){
    return new Predicate<String>() {
        public boolean apply(String candidate) {
            return string.startsWith(candidate);
        }
    };
}