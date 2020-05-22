@SupportedAnnotationTypes("com.gotofinal.direct.DirectMethod")
@SupportedSourceVersion(SourceVersion.RELEASE_8)
public class DirectAnnProcessor extends AbstractProcessor {

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        TypeElement stringType = processingEnv.getElementUtils().getTypeElement("java.lang.String");
        TypeElement expectedReturnType = processingEnv.getElementUtils().getTypeElement("com.gotofinal.direct.ReturnType");

        for (Element element : roundEnv.getElementsAnnotatedWith(DirectMethod.class)) {
            if (! (element instanceof ExecutableElement)) {
                processingEnv.getMessager().printMessage(Kind.ERROR, "Annotation should be on method.");
                continue;
            }
            ExecutableElement executableElement = (ExecutableElement) element;
            if (! executableElement.getReturnType().equals(expectedReturnType)) {
                processingEnv.getMessager().printMessage(Kind.ERROR, "Method should return ReturnType");
            }
            List<? extends VariableElement> parameters = executableElement.getParameters();
            if (parameters.size() != 1 && parameters.get(0).asType().equals(stringType)) {
                processingEnv.getMessager().printMessage(Kind.ERROR, "Method should have single String argument");
            }
        }
        return true; // no further processing of this annotation type
    }
}