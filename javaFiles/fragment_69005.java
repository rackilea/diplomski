public class Proc extends AbstractProcessor {
    @Override public Set<String> getSupportedAnnotationTypes() {
        return Collections.singleton("bar.Haha");
    }

    @Override public SourceVersion getSupportedSourceVersion() {
        return SourceVersion.RELEASE_8;
    }

    @Override public boolean process(final Set<? extends TypeElement> annotations,
                                     final RoundEnvironment roundEnv) {
        for (Element element : roundEnv.getElementsAnnotatedWith(Haha.class)) {
            if (element instanceof TypeElement) {
                TypeElement te = (TypeElement) element;
                for (TypeMirror typeMirror : te.getInterfaces()) {
                    if (typeMirror instanceof DeclaredType) {
                        DeclaredType dclt = (DeclaredType) typeMirror;
                        for (TypeMirror argument : dclt.getTypeArguments()) {
                            System.out.println(argument);
                        }
                    }
                }
            }
        }
        return false;
    }
}