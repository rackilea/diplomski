List<String> generate(String input) {
    ArrayList<String> output = new ArrayList<>();
    Stream.<BiConsumer<String, List<String>>>of(
            this::addFirstDependent,
            ignoreFirstArg(this::addSecondIndependent)
    ).forEach(g -> g.accept(input, output));
    return output;
}