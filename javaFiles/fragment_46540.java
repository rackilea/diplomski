public static void main(String[] args) throws NoSuchMethodException {
    Method m = Test.class.getDeclaredMethod("getThing", String.class);
    Type type = m.getGenericReturnType();
    // type is Thing<java.lang.String>
    if(type instanceof ParameterizedType) {
        Type[] innerTypes = ((ParameterizedType) type).getActualTypeArguments();
        if(innerTypes.length == 1) {
            Type innerType = innerTypes[0];
            if(innerType instanceof Class) {
                // innerType is java.lang.String class
                System.out.println(((Class<?>) innerType).getName());
            }
        }
    }
}