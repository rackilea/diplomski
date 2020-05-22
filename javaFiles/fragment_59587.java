public aspect ValidationAspect {

    pointcut serviceMethodCall() : execution(public * com.yourcompany.**.*(..));

    Object around(final Object[] args) : serviceMethodCall() && args(args){
        Signature signature = thisJoinPointStaticPart.getSignature();
        if(signature instanceof MethodSignature){
            MethodSignature ms = (MethodSignature) signature;
            Method method = ms.getMethod();
            Annotation[][] parameterAnnotations = 
                method.getParameterAnnotations();
            String[] parameterNames = ms.getParameterNames();
            for(int i = 0; i < parameterAnnotations.length; i++){
                Annotation[] annotations = parameterAnnotations[i];
                validateParameter(parameterNames[i], args[i],annotations);
            }
        }
        return proceed(args);
    }

    private void validateParameter(String paramName, Object object,
        Annotation[] annotations){

        // validate object against the annotations
        // throw a RuntimeException if validation fails
    }

}