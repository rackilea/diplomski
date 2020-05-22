class JsonEntity {

    public List<Map<String, List<String>>> list;
    public String kind;

    public StuffList toStuffList() {
        StuffList stuffList = createStuffListObject();

        return stuffList;
    }

    private StuffList createStuffListObject() {
        StuffList stuffList = new StuffList();
        stuffList.kind = kind;
        stuffList.list = createItemsList();

        return stuffList;
    }

    private List<Stuff> createItemsList() {
        List<Stuff> items = new ArrayList<Stuff>(list.size());
        for (Map<String, List<String>> item : list) {
            items.add(convertToStuff(item));
        }

        return items;
    }

    private Stuff convertToStuff(Map<String, List<String>> item) {
        Stuff stuff = new Stuff();
        stuff.name = item.keySet().iterator().next();
        stuff.items = item.values().iterator().next();

        return stuff;
    }
}