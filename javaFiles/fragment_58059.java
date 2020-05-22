import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.QualifiedNameable;
import javax.lang.model.element.TypeElement;
import javax.tools.StandardLocation;

@SupportedSourceVersion(SourceVersion.RELEASE_7)
public class AnnotationServiceProcessor extends AbstractProcessor {

    // Map name of the annotation to name of the corresponding service interface
    private static Map<String, String> annotationToServiceMap = new HashMap<>();

    static {
        // Adapt this to your use, or make it configurable somehow
        annotationToServiceMap.put("Annotation1", "Service1");
        annotationToServiceMap.put("Annotation2", "Service2");
    }

    @Override public Set<String> getSupportedAnnotationTypes() {
        return annotationToServiceMap.keySet();
    }

    // Map name of the annotation to list of names
    // of the classes which carry that annotation
    private Map<String, List<String>> classLists;

    @Override public void init(ProcessingEnvironment env) {
        super.init(env);
        classLists = new HashMap<>();
        for (String ann: getSupportedAnnotationTypes())
            classLists.put(ann, new ArrayList<String>());
    }

    public boolean process(Set<? extends TypeElement> annotations,
                           RoundEnvironment env) {
        for (TypeElement ann: annotations) {
            List<String> classes =
                classLists.get(ann.getQualifiedName().toString());
            for (Element elt: env.getElementsAnnotatedWith(ann)) {
                QualifiedNameable qn = (QualifiedNameable)elt;
                classes.add(qn.getQualifiedName().toString());
            }
        }
        if (env.processingOver()) { // Only write results at the end
            for (String ann: getSupportedAnnotationTypes()) {
                try {
                    write(ann, classLists.get(ann));
                } catch (IOException e) {
                    throw new RuntimeException(e); // UGLY!
                }
            }
        }
        return true;
    }

    // Write the service file for each annotation we found
    private void write(String ann, List<String> classes) throws IOException {
        if (classes.isEmpty())
            return;
        String service = annotationToServiceMap.get(ann);
        Writer w = processingEnv.getFiler()
            .createResource(StandardLocation.CLASS_OUTPUT,
                            "", "META-INF/services/" + service)
            .openWriter();
        classes.sort(null); // Make the processing order irrelevant
        for (String cls: classes) {
            w.write(cls);
            w.write('\n');
        }
        w.close();
    }

}