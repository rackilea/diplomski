<T extends A> T getFirstObjInList(Class<T> type) {
    for (A a : list) {
        if (a.getClass() == type) {
            return type.cast(a);
        }
    }
    return null;
}