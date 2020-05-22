class ListProp<T> extends Prop<List<T>> {
    Class<T> subtype;
    public ListProp(Class<T> type) {
        super((Class<List<T>>)(Class<?>)List.class); // magic double cast
        subtype = type;
    }
}