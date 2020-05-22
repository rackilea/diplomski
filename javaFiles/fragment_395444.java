public class MyInterfaceFactory {

    @Produces
    @MyClassType
    public MyInterface createMyClasses(@Any Instance<MyInterface> instance, InjectionPoint injectionPoint) {
        Annotated annotated = injectionPoint.getAnnotated();
        ClassType classTypeAnnotation = annotated.getAnnotation(ClassType.class);
        Class<? extends MyInterface> classType = classTypeAnnotation.value().getClassType();
        return instance.select(classType).get();
    }
}