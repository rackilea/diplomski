public <T> getList(Class<T> key) {
    List<?> list = map.get(key);
    for(Object o : list){
        assert(key.isInstance(o));
    }
    return (List<T>) list;
}