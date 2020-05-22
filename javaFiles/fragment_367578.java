RuleDependency dependency = element.getAnnotation(RuleDependency.class);

// first try to get the parser type from the annotation
TypeMirror recognizerType = getRecognizerType(dependency);
if (recognizerType != null && !recognizerType.toString().equals(Parser.class.getName())) {
    result.add(new Triple<RuleDependency, TypeMirror, Element>(dependency, recognizerType, element));
    continue;
}

// fallback to compiler tree API
AnnotationMirror annotationMirror = null;
for (AnnotationMirror mirror : element.getAnnotationMirrors()) {
    if (processingEnv.getTypeUtils().isSameType(ruleDependencyTypeElement.asType(), mirror.getAnnotationType())) {
        annotationMirror = mirror;
        break;
    }
}

AnnotationValue annotationValue = null;
for (Map.Entry<? extends ExecutableElement, ? extends AnnotationValue> entry : annotationMirror.getElementValues().entrySet()) {
    if (entry.getKey().getSimpleName().contentEquals("rule")) {
        annotationValue = entry.getValue();
        break;
    }
}

TreePath treePath = trees.getPath(element, annotationMirror, annotationValue);
AnnotationVisitor visitor = new AnnotationVisitor();
recognizerType = visitor.scan(treePath, null);

result.add(new Triple<RuleDependency, TypeMirror, Element>(dependency, recognizerType, element));