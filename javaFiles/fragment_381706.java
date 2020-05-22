public static void main(String[] args) throws Exception{

    ObjectMapper mapper = new ObjectMapper();
    mapper.configure(MapperFeature.DEFAULT_VIEW_INCLUSION, false);
    mapper.configure(MapperFeature.AUTO_DETECT_FIELDS, false);
    mapper.configure(MapperFeature.AUTO_DETECT_IS_GETTERS, false);
    mapper.configure(MapperFeature.AUTO_DETECT_GETTERS, false);
    mapper.configure(MapperFeature.AUTO_DETECT_SETTERS, false);
    mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
    mapper.configure(SerializationFeature.INDENT_OUTPUT, true);

    SimpleModule simpleModule = new SimpleModule();
    simpleModule.addSerializer(Link.class, new LinkSerializer());
    mapper.registerModule(simpleModule);

    Link link1 = Link.fromUri(URI.create("http://localhost:8080/")).rel("one").build();
    Link link2 = Link.fromUri(URI.create("http://localhost:8080/")).rel("two").build();
    TestClass test = new TestClass();
    test.getLinks().add(link1);
    test.getLinks().add(link2);
    String json = mapper.writeValueAsString(test);
    System.out.println(json);
}