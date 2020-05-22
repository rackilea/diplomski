public static class TestObject {
    private Integer id;

    public TestObject(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}

public static class TestObjectService {

    @GraphQLQuery(name = "TestObject")
    public TestObject getRoot() { //no GraphQL-specific classes mentioned
        return getRandom();
    }

    @GraphQLQuery(name = "child")
    public TestObject getChild(@GraphQLContext TestObject parent) {
        return getRandom();
    }

    private TestObject getRandom() {
        return new TestObject(ThreadLocalRandom.current().nextInt());
    }
}

@Test
public void test() {
    GraphQLSchema schema = new GraphQLSchemaGenerator()
            .withOperationsFromSingleton(new TestObjectService())
            .generate(); //that's all :)
    GraphQL graphQL = GraphQL.newGraphQL(schema).build();

    ExecutionResult result = graphQL.execute("{ TestObject { id, child { id , child { id }}}}"); //your query has a syntax error
    assertFalse(result.getErrors() != null && !result.getErrors().isEmpty());
    assertNotNull(result.getData());
}