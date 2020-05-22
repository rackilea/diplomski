@SupportedAnnotationTypes("package.of.MyAnnotation")
@SupportedSourceVersion(SourceVersion.RELEASE_8)
@AutoService(Processor.class)
public class BuilderProcessor extends AbstractProcessor {

    @Override
    public boolean process(Set<? extends TypeElement> annotations, 
                           RoundEnvironment roundEnv) {
        // First let's find all annotated elements
        Set<? extends Element> annotatedElements = roundEnv.getElementsAnnotatedWith(MyAnnotation.class);
        // Handle all the annotated classes
        return false;
    }
}