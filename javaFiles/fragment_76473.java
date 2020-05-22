private void callOptionTwoFromStream() {
    List<String> foo = Arrays.asList(new String[] { "a", "b", "c" });
    Stream<String> stream = foo.stream();
    // use stream here
    optionTwoCollection(stream.collect(Collectors.toList())); //clumsy
}
private void callOptionTwoFromObject() {
    String bar = "a";
    optionTwoCollection(Collections.singletonList(bar)); //clumsy
}
private void optionTwoCollection(Collection<String> params) {
    Stream<String> stream = params.stream();
    // use the new stream on the newly created collection
}