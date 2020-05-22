interface TypeFunction {
    <T> T apply(Class<T> clazz);
}

public void consume(TypeFunction getInputs) {
    MyType type = getInputs.apply(MyType.class);
}