package com.example;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.AnnotationMirror;
import javax.lang.model.element.Element;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.TypeElement;
import javax.tools.Diagnostic.Kind;
import java.util.Set;

@SupportedAnnotationTypes("com.example.Foo")
@SupportedSourceVersion(SourceVersion.RELEASE_13) // or whatever version you support
public class FooProcessor extends AbstractProcessor {

  @Override
  public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
    if (!annotations.isEmpty()) {
      // This processor is only declared to process one annotation
      TypeElement foo = annotations.iterator().next();

      for (Element element : roundEnv.getElementsAnnotatedWith(foo)) {
        for (AnnotationMirror mirror : element.getAnnotationMirrors()) {
          if (mirror.getAnnotationType().asElement().equals(foo)
              && element.getModifiers().contains(Modifier.FINAL)) {
            // processingEnv is a protected field of AbstractProcessor
            processingEnv.getMessager()
                .printMessage(Kind.ERROR, "Field cannot be final.", element, mirror);
            break;
          }
        }
      }
    }
    return true;
  }
}