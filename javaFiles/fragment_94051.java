Map<IdType, List<B>> map = new HashMap<IdType, List<B>>();
for(each b in B) {
    List<B> list = map.get(b.id);
    if (list == null) {
        list = new ArrayList<B>();
        map.put(b.id, list);
    }
    list.add(b);
}
for(each a in A) {
    a.b_list = map.get(a.id);
    // if you need an empty list instead of null:
    if (a.b_list == null) {
        a.b_list = new ArrayList<B>();
    }
}