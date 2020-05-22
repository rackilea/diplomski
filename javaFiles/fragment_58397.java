class Item {
    int id;
    Item (int i) {
        id = i;
    }
    int getItemId() {
        return id;
    }
}

private static List<Integer> getRecentList(List<Integer> searchParams, 
        Function<List<Integer>, List<Item>> listGetter,
        Function<Item, Integer> idGetter)
{
    List<Item> itemList = listGetter.apply(searchParams);
    List<Integer> idList = new ArrayList<>();
    for (Item item: itemList)
    {
        idList.add(idGetter.apply(item));
    }
    return idList;
}