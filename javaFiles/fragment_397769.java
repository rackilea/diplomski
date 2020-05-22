VariableElement param = ...;
for (AnnotationMirror mirror : param.getAnnotationMirrors()) {
    DeclaredType t = mirror.getAnnotationType();
    // (Filter out ErrorType: see my addendum.)
    if (t.getKind() == TypeKind.DECLARED) {
        Element e = t.asElement();
        // (This should always be true.)
        if (e.getKind() == ElementKind.ANNOTATION_TYPE) {
            Argument a = e.getAnnotation(Argument.class);
            // ...
        }
    }
}