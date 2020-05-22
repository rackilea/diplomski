public class ParameterAliasExtension extends DefaultParameterExtension {

    @Override
    public ResolvedParameter extractParameters(List<Annotation> annotations,
                                               Type type,
                                               Set<Type> typesToSkip,
                                               Components components,
                                               javax.ws.rs.Consumes classConsumes,
                                               javax.ws.rs.Consumes methodConsumes,
                                               boolean includeRequestBody,
                                               JsonView jsonViewAnnotation,
                                               Iterator<OpenAPIExtension> chain) {
        List<Annotation> extendedAnnotations = null;
        if (null != annotations) {
            extendedAnnotations = new ArrayList<>(annotations);
            ParameterAlias alias = AnnotationsUtils.getAnnotation(ParameterAlias.class, annotations.toArray(new Annotation[0]));
            if (null != alias) {
                Parameter aliasParameter = AnnotationsUtils.getAnnotation(Parameter.class, alias.value().getDeclaredAnnotations());
                if (null != aliasParameter) {
                    extendedAnnotations.add(aliasParameter);
                }
            }
        }
        return super.extractParameters(extendedAnnotations == null ? annotations : extendedAnnotations, 
                type, 
                typesToSkip, 
                components, 
                classConsumes, 
                methodConsumes, 
                includeRequestBody, 
                jsonViewAnnotation, 
                chain);
    }
}