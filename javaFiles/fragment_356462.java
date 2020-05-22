@Override
public boolean process(Set<? extends TypeElement> annotations,
                       RoundEnvironment           env) {
    if (shouldClaim(annotations)) {
        for (Element e : env.getElementsAnnotatedWith(MyAnnotation.class)) {
            MyAnnotation a = e.getAnnotation(MyAnnotation.class);

            String str1 = a.strNumberOne();
            String str2 = a.strNumberTwo();
            String str3 = a.strNumberThree();
            // Add them to a List or whatever you need.
        }

        return true;
    }
    return false;
}

private boolean shouldClaim(Set<? extends TypeElement> annotations) {
    Set<String> supported = getSupportedAnnotationTypes();
    for (TypeElement a : annotations) {
        if (supported.contains(a.getQualifiedName().toString()))
            return true;
    }
    return false;
}