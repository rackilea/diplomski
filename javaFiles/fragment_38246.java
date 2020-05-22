class MyMethodValidationPostProcessor extends MethodValidationPostProcessor {

    @Override
    protected Advice createMethodValidationAdvice(Validator validator) {
        return (validator != null ? new MyMethodValidationInterceptor(validator) : new MyMethodValidationInterceptor());
    }
}