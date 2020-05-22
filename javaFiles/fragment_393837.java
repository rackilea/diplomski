@SupportedAnnotationTypes("core.Factory")
public class MyProcessor extends AbstractProcessor {
Messager messager;

    @Override
    public void init(ProcessingEnvironment env) {
        messager = env.getMessager();
        super.init(env);
    }

    @Override
    public boolean process(Set<? extends TypeElement> annotations,       RoundEnvironment roundEnv) {
        for (TypeElement te : annotations)
            for (Element e : roundEnv.getElementsAnnotatedWith(te))
                messager.printMessage(Diagnostic.Kind.NOTE, "Printing: " +   e.toString());
        return true;
    }

    @Override
    public SourceVersion getSupportedSourceVersion() {
        return SourceVersion.latestSupported();
    }
}