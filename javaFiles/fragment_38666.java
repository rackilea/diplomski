Type[] genericInterfaces = BarFoo.class.getGenericInterfaces();
for (Type genericInterface : genericInterfaces) {
    if (genericInterface instanceof ParameterizedType) {
        Type[] genericTypes = ((ParameterizedType) genericInterface).getActualTypeArguments();
        for (Type genericType : genericTypes) {
            System.out.println("Generic type: " + genericType);
        }
    }
}