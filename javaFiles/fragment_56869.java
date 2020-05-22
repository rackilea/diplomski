public aspect AnnotatedMethodParameterMatchingAspect  {

    /**
     * Matches the execution of any method having a parameter annotated with the
     * {@link MyAnnotation} annotation.
     */
    pointcut executionOfMethodWithAnnotatedParameter(): 
        execution(* *(.., @MyAnnotation (*), ..));

    /**
     * Matches the execution of any method having a parameter annotated with the
     * {@link MyAnnotation} annotation where the parameter type is a {@link MyType}
     * (or a subtype).
     */
    pointcut executionOfMethodWithAnnotatedTypeRestrictedParameter(): 
        execution(* *(.., @MyAnnotation (MyType+), ..));

}