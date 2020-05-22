@SupportedSourceVersion(SourceVersion.RELEASE_6)
@SupportedAnnotationTypes("*")
public class CodeAnalyzerProcessor extends AbstractProcessor {
    @Override
    public boolean process(Set<? extends TypeElement> annotations,
                          RoundEnvironment roundEnvironment) {
        for (Element e : roundEnvironment.getRootElements()) {
            System.out.println("Element is "+ e.getSimpleName());
            // Add code here to analyze each root element
         }
         return true;
    }
}