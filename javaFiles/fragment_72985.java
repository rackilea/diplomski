Map<Class<?>, DataOperationsFactory<?>> map;

// Unchanged
public Test(List<DataOperationsFactory<?>> fs) {
    for(DataOperationsFactory<?> f : fs) {
        map.put(f.getDataClass(), f);
    }
}

public DataOperations getOps(Data data) {
    DataOperationsFactory<?> f = map.get(data.getClass());
    return getOperations(f, data);
}

private static <T extends Data> DataOperations getOperations(DataOperationsFactory<T> f,
                                                             Data data) {
    return f.getOperations(f.getDataClass().cast(data));
}