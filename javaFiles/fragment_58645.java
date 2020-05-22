private static class ListParameterizedType implements ParameterizedType {
    private final Type[] typeArguments;

    private ListParameterizedType(Type[] typeArguments) {
        this.typeArguments = typeArguments;
    }

    @Override
    public Type[] getActualTypeArguments() {
        return typeArguments;
    }

    @Override
    public Type getRawType() {
        return ArrayList.class;
    }

    @Override
    public Type getOwnerType() {
        return null;
    }
}