protected <T> T read(String key, Class<T> valueType) throws Exception{
    Path pathReadFrom = Paths.get(getPath(key));
    T object = JSON_MAPPER.readValue(Files.readAllBytes(pathReadFrom), valueType);
    return object;
}

public MyClass get(String id) throws Exception {
    MyClass object = storeManager.read(id, MyClass.class);
    return object;
}