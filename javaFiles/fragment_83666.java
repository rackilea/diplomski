interface MyMethodType<T> {
  T method(String name, Object[] objects);
}


private <T> T createTypeWithCorrectSearchPath(
            String typeName, 
            Object[] objects, 
            MyMethodType<T> impl) {
    String searchPath = getSearchPath();
    String name = setSearchPathToSchema(typeName);
    T ret = impl.method(name, objects);
    setSearchPath(searchPath);
    return ret;
}

createTypeWithCorrectSearchPath(typeName, objects, delegate()::createStruct);