private static boolean testSomePropertyTrue(Collection<T> collection) {
    boolean test = true;
    for (T obj : collection){
        test = test && obj.someProperty();
    }
    return test;
}