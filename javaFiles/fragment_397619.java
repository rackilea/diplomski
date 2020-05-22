PropertyResolver resolver =
    new FizzBuzzResolver(
        new FooBarResolver(
            new UnknownResolver(),
            new FooBarService()),
        new FizzBuzzService());

Map<String, Object> result = resolver.resolve(Arrays.asList(
    "foobar", "foo", "__bar", "barfoo", "invalid", "fizz"));

ObjectMapper mapper = new ObjectMapper();
mapper.enable(SerializationFeature.INDENT_OUTPUT);
System.out.println(mapper
    .writerWithDefaultPrettyPrinter()
    .writeValueAsString(result));