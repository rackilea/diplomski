public static<T,Q> Object[][] toArray (Map<T,Q> map) {
    if(map == null) {
        return null;
    }
    Object[][] result = new Object[map.size()][];
    int index = 0;
    for(Map.Entry<T,Q> e : map.entrySet()) {
        result[index++] = new Object[] {e.getKey(),e.getValue()};
    }
    return result;
}