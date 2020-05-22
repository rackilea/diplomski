class TypeToListMap {
    private Map<Class<?>, List<Object>> map = ...

    public <T> List<T> get(Class<T> key) {
        @SuppressWarnings("unchecked")
        List<T> result = (List<T>)map.get(key); 
        return result;
    }
}