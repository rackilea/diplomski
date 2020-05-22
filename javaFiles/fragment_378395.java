public class MyClass
{
    @GraphQLField
    private Integer id;
    private List<String> items;

    @GraphQLField
    public List<String> items(DataFetchingEnvironment environment, @GraphQLName("take") Integer take, @GraphQLName("after") Integer after)
    {
        List<String> items = ((MyClass) environment.getSource()).getItems();

        Integer fromIndex = 0;
        Integer toIndex = items.size();
        if (after != null)
            fromIndex = after + 1;
        if (take != null)
            toIndex = fromIndex + take;

        return items.subList(fromIndex, toIndex);
    }
}