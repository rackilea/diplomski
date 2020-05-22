@Override
public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
    for(TypeElement test: annotations) {
        for( Element elem : roundEnv.getElementsAnnotatedWith( test ) ) {
            System.out.println(elem);
            for(AnnotationMirror am: elem.getAnnotationMirrors()) {
                if(am.getAnnotationType().asElement()==test)
                    am.getElementValues().forEach((ee,av) ->
                        System.out.println("\t"+ee.getSimpleName()+" = "+av.getValue())
                    );
            }
        }
    }
    return true;
}