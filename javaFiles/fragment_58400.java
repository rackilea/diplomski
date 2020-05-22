class ItemA {
    int id;
    ItemA(int i) {
        id = i;
    }
    public int getItemIdA() {
        return id;
    }
}
class ItemB {
    int id;
    ItemB(int i) {
        id = i;
    }
    public int getItemIdB() {
        return id;
    }
}

private List<Integer> getRecentList(List<Integer> searchParams,
        Function<List<Integer>, List<Object>> listGetter,
        Function<Object, Integer> idGetter)
{
    List<Object> itemList = listGetter.apply(searchParams);
    List<Integer> idList = new ArrayList<>();
    for (Object item: itemList)
    {
        idList.add(idGetter.apply(item));
    }
    return idList;
}

List<Integer> idList = getRecentList(searchParams,
        (a) -> getItemList(a),
        (item) -> ((ItemA) item).getItemIdA());
// or
List<Integer> idList = getRecentList(searchParams,
        (a) -> getItemList(a),
        (item) -> ((ItemB) item).getItemIdB());