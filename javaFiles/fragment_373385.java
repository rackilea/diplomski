@AutoService(Processor.class)
public class ResponsibleAnnotationProcessor extends AbstractProcessor {
    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment env) {
            List<ElementKind> typeKinds = Arrays.asList(ElementKind.ENUM, ElementKind.INTERFACE, ElementKind.CLASS);
            // let's gather all types we are interrested in
            Set<String> allElements = env.getRootElements()
                    .stream()
                    .filter(e -> typeKinds.contains(e.getKind()))   // keep only interesting elements
                    .map(e -> e.asType().toString())                // get their full name
                    .collect(Collectors.toCollection(() -> new HashSet<>()));
            Set<String> typesWithResponsible = new HashSet<>();

            annotations.forEach(te -> {
                if (Responsible.class.getName().equals(te.asType().toString())) {
                    // We collect elements with an already declared  ownership 
                    env.getElementsAnnotatedWith(te).forEach(e -> typesWithResponsible.add(e.asType().toString()));
                }
            });

            allElements.removeAll(typesWithResponsible);
            allElements.forEach(cname -> processingEnv.getMessager().printMessage(Diagnostic.Kind.ERROR, cname + " must be annotated with @" + Responsible.class.getName() + " to declare a ownership"));
            return false;
    }

    @Override
    public SourceVersion getSupportedSourceVersion() {
      return SourceVersion.latestSupported();
    }

    @Override
    public Set<String> getSupportedAnnotationTypes() {
        // We want to process all elements
        return Collections.singleton("*");
    }
}