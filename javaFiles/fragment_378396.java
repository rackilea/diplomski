public class MyClass
{
    @GraphQLField
    private Integer id;
    private List<String> items;

    @GraphQLField
    @GraphQLDataFetcher(MyClassDataFetcher.class)
    public List<String> items(DataFetchingEnvironment environment, @GraphQLName("take") Integer take, @GraphQLName("after") Integer after)
    {
        return null;
    }

}