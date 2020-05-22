private void callOptionThreeFromStream() {
    List<String> foo = Arrays.asList(new String[] { "a", "b", "c" });
    Stream<String> stream = foo.stream();
    // use stream here
    optionThreeStream(stream);
}
private void callOptionThreeFromObject() {
    String bar = "a";
    optionThreeStream(Stream.of(bar)); //very simple conversion
}
private void optionThreeStream(Stream<String> params) {
    // use the same stream (and possibly profit from optimization)
}