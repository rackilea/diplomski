private static final MethodHandle dataGetter;

static {
    Field dataField;
    try {
        dataField = SomeControllerInALibraryThatICantEdit.class.getDeclaredField("dataClass");
        dataField.setAccessible(true); // or trySetAccessible for new java
        dataGetter = MethodHandles.lookup().unreflectGetter(dataField);
    } catch (NoSuchFieldException | IllegalAccessException e) {
        throw new RuntimeException(e);
    }
}