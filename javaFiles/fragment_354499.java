public Car getCarInstance(Object param) {
    try {
        return type.getConstructor(Object.class).newInstance(param);
    } catch (ReflectiveOperationException e) {
        throw new IllegalStateException(e);
    }
}