public static boolean isParameterSpecSameAsAnnotatedType(ParameterSpec parameter, AnnotatedType type) {
  if (!parameter.type.equals(TypeName.get(type.getType())))
    return false;

  List<AnnotationSpec> typeAnnotations = Arrays.asList(type.getAnnotations()).stream()
    .map(AnnotationSpec::get)
    .collect(Collectors.toList());

  return parameter.annotations.equals(typeAnnotations);
}