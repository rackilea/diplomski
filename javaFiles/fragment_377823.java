for (TypeElement typeElement : annotations) {
    // it's likely the ElementKind.ANNOTATION_TYPE
    typeElement.getKind();

    // elements annotated with the annotation
    environment.getElementsAnnotatedWith(typeElement);
}