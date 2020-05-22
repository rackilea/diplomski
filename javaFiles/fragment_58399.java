private List<Integer> getRecentList(List<Integer> searchParams,
        Function<List<Integer>, List<ItemWithId>> listGetter,
        Function<ItemWithId, Integer> idGetter)
{
    List<ItemWithId> itemList = listGetter.apply(searchParams);
    List<Integer> idList = new ArrayList<>();
    for (ItemWithId item: itemList)
    {
        idList.add(idGetter.apply(item));
    }
    return idList;
}