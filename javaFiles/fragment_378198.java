public static void main(String[] args) {
    Reflections reflections = new Reflections(Test.class.getCanonicalName(),
            new SubTypesScanner(false),
            new TypeAnnotationsScanner(),
            new FieldAnnotationsScanner());
    {
        Set<Field> annotated = reflections.getFieldsAnnotatedWith(MyAnnotation.class);
        for (Field controller : annotated) {
            Type genericType = controller.getGenericType();
            if(genericType instanceof ParameterizedType){
                for(Type genericTypeArg: ((ParameterizedType)genericType).getActualTypeArguments()) {
                    System.out.println("Generic Type Arg: "+genericTypeArg.getTypeName());
                }
            } else {
                System.out.println("Can't determine generic type");
            }
        }
    }
}