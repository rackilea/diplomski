CharStream stream = 
    new ANTLRInputStream(
        "java.util.Map<java.util.List<java.lang.Integer>, java.util.Set<java.lang.String>>"
    );

TokenStream tokenStream = 
    new CommonTokenStream(new ParametrizedTypeLexer(stream));
ParametrizedTypeParser parser = 
    new ParametrizedTypeParser(tokenStream);

assertEquals(
        new TypeToken<Map<List<Integer>, Set<String>>>() {}.getType(),
        parser.type().value.build()
);