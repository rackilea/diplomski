public Class<?> getType(Object o) {
    return o.getClass();
}

public Class<?> getType(short s) {
    return short.class;
}

public Class<?> getType(int i) {
    return int.class;
} 

// add overloads with other primitive types if required