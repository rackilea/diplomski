private void callOptionOneFromStream() {
    List<String> foo = Arrays.asList(new String[] { "a", "b", "c" });
    Stream<String> stream = foo.stream();
    // use stream here
    optionOneVararg(stream.toArray(String[]::new)); //still clumsy
}
private void callOptionOneFromObject() {
    String bar = "a";
    optionOneVararg(bar); //but optimal here
}
private void optionOneVararg(String... params) {
    Stream<String> stream = Stream.of(params);
    // use the new stream on the newly created array
}