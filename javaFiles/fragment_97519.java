interface Filter<T> {
    boolean include(T item);

    public final static Filter<Object> INCLUDE_ALL = new Filter<Object>() {
        @Override
        public boolean include(Object item) {
            return true; /* includes everything unconditionally */
        }
    };
}



public static int sumFilter(Collection<MyClass> collection, 
        Filter<? super MyClass> filter) {

    int result = 0;
    if (filter == null) {
        filter = Filter.INCLUDE_ALL;
    }
    for (MyClass item : collection) {
        if (filter.include(item)) {
            result += item.value;
        }
    }
    return result;
 }

public static int sumAll(Collection<MyClass> collection) {
    return sumFilter(collection, Filter.INCLUDE_ALL);
}