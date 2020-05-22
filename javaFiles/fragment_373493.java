private class MyObjectIdResolver implements ObjectIdResolver {
    private Map<ObjectIdGenerator.IdKey,Object> _items  = new HashMap<>();

    @Override
    public void bindItem(ObjectIdGenerator.IdKey id, Object pojo) {
        if (!_items.containsKey(id)) _items.put(id, pojo); 
    }

    @Override
    public Object resolveId(ObjectIdGenerator.IdKey id) {
        Object object = _items.get(id);
        return object == null ? getById(id) : object;
    }

    protected Object getById(ObjectIdGenerator.IdKey id){
        Object object = null;
        try {
            //can resolve object from db here
            //objectRepository.getById((Integer)idKey.key, idKey.scope)
            object = id.scope.getConstructor().newInstance();
            id.scope.getMethod("setId", int.class).invoke(object, id.key);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return object;
    }

    @Override
    public ObjectIdResolver newForDeserialization(Object context) {
        return new MyObjectIdResolver();
    }

    @Override
    public boolean canUseFor(ObjectIdResolver resolverType) {
        return resolverType.getClass() == getClass();
    }
}