public class MyClassProducer {
    @Inject
    private Instance<MyClass> myClasses;

    @Produces
    @Any
    public MyClass getMyClassFromTransferedAnnotations(InjectionPoint ip) {
        Set<Annotations> qualifiers  = ip.getBean().getQualifiers();
        for(Annotation an : annotations) {
            if(an.getAnnotationType().isAnnotationPresent(Transferable.class)) {
                    return myClasses.select(an.getAnnotationType);
            }
        }
        return null; // Todo : think about throwing an UnsatisfiedDependenciesException
    }
}