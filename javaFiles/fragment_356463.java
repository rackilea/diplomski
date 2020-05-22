Elements    elements     = processingEnv.getElementUtils();
TypeElement myAnnotation = elements.getTypeElement("com.example.MyAnnotation");

for (Element e : env.getElementsAnnotatedWith(myAnnotation)) {
    for (AnnotationMirror mirror : e.getAnnotationMirrors()) {
        DeclaredType annotationType = mirror.getAnnotationType();
        Element      annotationDecl = annotationType.asElement();

        if (myAnnotation.equals(annotationDecl)) {
            Map<? extends ExecutableElement, ? extends AnnotationValue> values =
                elements.getAnnotationValuesWithDefaults(mirror);

            String str1 = (String) getValue(values, "strNumberOne");
            String str2 = (String) getValue(values, "strNumberTwo");
            String str3 = (String) getValue(values, "strNumberThree");
            // ...
        }
    }
}

private Object getValue(Map<? extends ExecutableElement,
                            ? extends AnnotationValue> values,
                        String name) {
    for (Map.Entry<? extends ExecutableElement,
                   ? extends AnnotationValue> e : values.entrySet()) {
        if (name.contentEquals(e.getKey().getSimpleName()))
            return e.getValue().getValue();
    }
    return null;
}