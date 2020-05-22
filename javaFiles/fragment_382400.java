protected void validateIfApplicable(WebDataBinder binder, MethodParameter parameter) {
    Annotation[] annotations = parameter.getParameterAnnotations();
    for (Annotation ann : annotations) {
        if (ann.annotationType().getSimpleName().startsWith("Valid")) {
            Object hints = AnnotationUtils.getValue(ann);
            binder.validate(hints instanceof Object[] ? (Object[]) hints : new Object[] {hints});
            break;
        }
    }
}