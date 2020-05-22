io.swagger.v3.oas.annotations.Parameter paramAnnotation = AnnotationsUtils.getAnnotation(io.swagger.v3.oas.annotations.Parameter.class, paramAnnotations[i]);
Type paramType = ParameterProcessor.getParameterType(paramAnnotation, true);
if (paramType == null) {
    paramType = type;
} else {
    if (!(paramType instanceof Class)) {
        paramType = type;
    }
}
ResolvedParameter resolvedParameter = getParameters(paramType, Arrays.asList(paramAnnotations[i]), operation, classConsumes, methodConsumes, jsonViewAnnotation);