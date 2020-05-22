public <T extends GeometryObject> List<T> getList(Class<T> itemClass) throws Exception {
    List<T> res = new ArrayList<T>();
    for (int i = 0 ; i != 10 ; i++) {
        res.add(itemClass.newInstance());
    }
    return res;
}