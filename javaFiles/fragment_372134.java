public static Collection<String> getPropertyNamesListWithAnnotation(Class<?> targetClass, Class<? extends Annotation> annotationClass) {
    Set<String> fieldNamesWithAnnotation = FieldUtils.getFieldsListWithAnnotation(targetClass, annotationClass).stream().map(Field::getName).collect(Collectors.toSet());
    fieldNamesWithAnnotation.addAll(MethodUtils.getMethodsListWithAnnotation(targetClass, annotationClass, true, false).stream()
            .map(Method::getName)
            .filter(LangHelper::isValidGetterOrSetter)
            .map(name -> StringUtils.uncapitalize(RegExUtils.replaceFirst(name, "^(get|set|is)", "")))
            .collect(Collectors.toSet()));
    return fieldNamesWithAnnotation;
}

private static boolean isValidGetterOrSetter(String methodName) {
    if (!StringUtils.startsWithAny(methodName, "get", "set", "is")) {
        LOG.warn("Annotated method is no valid getter or setter: '{}' -> Ignoring", methodName);
        return false;
    }
    return true;
}