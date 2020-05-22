package com.example;

import javax.annotation.processing.*;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.tools.Diagnostic;
import javax.tools.JavaFileObject;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.Map;
import java.util.Set;

@SupportedAnnotationTypes("com.example.ProcessorStarterAnnotation")
@SupportedSourceVersion(SourceVersion.RELEASE_6)
@SupportedOptions({"textToPrint", "enablePrint"})
public class ConfigWritterAnnotationProcessor extends AbstractProcessor {
  private Map<String,String> options;

  @Override
  public synchronized void init(ProcessingEnvironment processingEnv) {
    super.init(processingEnv);
    options = processingEnv.getOptions();
  }

  @Override
  public boolean process(Set<? extends TypeElement> annotations,
                         RoundEnvironment currentRound) {

    if (!currentRound.processingOver()) {
      // This for-s are because processor is also run on newly created Options class.
      for (TypeElement te : annotations) {
        for (Element e : currentRound.getElementsAnnotatedWith(te)) {
          try {
            processingEnv.getMessager().printMessage(Diagnostic.Kind.NOTE, "Creating com.example.Options");
            JavaFileObject javaFile = processingEnv.getFiler().createSourceFile("com.example.Options");
            Writer w = javaFile.openWriter();
            try {
              PrintWriter pw = new PrintWriter(w);
              pw.println("package com.example;");
              pw.println("public class Options {");
              pw.println("    public static final String textToPrint = \"" + options.get("textToPrint") + "\";");
              pw.println("    public static final boolean enablePrint = " + options.get("enablePrint") + ";");
              pw.println("}");
              pw.flush();
            } finally {
              w.close();
            }
          } catch (IOException x) {
            processingEnv.getMessager().printMessage(Diagnostic.Kind.ERROR,
                x.toString());
          }
        }
      }
    }
    return false;
  }
}