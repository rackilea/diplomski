public interface ListMap extends List<Map<String,Object>> {
    public static ListMap newArrayList() {
        return wrap(new ArrayList<>());
    }
    public static ListMap wrap(List<Map<String,Object>> list) {
        if (list instanceof ListMap)
            return (ListMap) list;
        class Wrapper extends DelegatingList<Map<String,Object>> implements ListMap {
            protected Wrapper() {
                super(list);
            }
        }
        return new Wrapper();
    }
}