public K create(V entity) {
        K pk = entity.getPk();
        if (!pk.validate()) {
            throw new IllegalArgumentException("Part of primary key is null:" + entity);
        }
        if (getInstances().containsKey(pk)) {
            throw new IllegalArgumentException(entity + " already exists.");
        }
        getInstances().put(pk, entity);
        return pk;
    }

    public abstract Map<K, V> getInstances();
}