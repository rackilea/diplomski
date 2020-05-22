public final class MySerializedLambda implements Serializable {
    private final Class<?> capturingClass;
    private final String functionalInterfaceClass;
    private final String functionalInterfaceMethodName;
    private final String functionalInterfaceMethodSignature;
    private final String implClass;
    private final String implMethodName;
    private final String implMethodSignature;
    private final int implMethodKind;
    private final String instantiatedMethodType;
    private final Object[] capturedArgs;

    private MySerializedLambda() {
        throw new UnsupportedOperationException();
    }

    private Object readResolve() throws ReflectiveOperationException {
        String funcInterfaceClass = this.functionalInterfaceClass;
        if(funcInterfaceClass.equals("package/to/old/SerializableFunction")) {
            funcInterfaceClass="package/to/new/SerializableFunction";
        }
        SerializedLambda serializedLambda = new SerializedLambda(capturingClass,
            funcInterfaceClass, functionalInterfaceMethodName,
            functionalInterfaceMethodSignature, implMethodKind, implClass, implMethodName,
            implMethodSignature, instantiatedMethodType, capturedArgs);
        Method m = capturingClass
                  .getDeclaredMethod("$deserializeLambda$", SerializedLambda.class);
        m.setAccessible(true);
        return m.invoke(null, serializedLambda);
    }
}