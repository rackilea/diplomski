package acme.annotation.processing;

import java.util.HashSet;
import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.lang.model.element.TypeElement;

import acme.annotation.FooEntity;

@SupportedAnnotationTypes("*")
public class FooEntityExtendedProcessor extends AbstractProcessor {

    private void log(String msg) {
        System.out.println(msg);
    }

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        log("Initially I was asked to process:" + annotations.toString());

        Set<TypeElement> fooAnnotations = new HashSet<>();
        for (TypeElement elem : annotations) {
            if (isFoo(elem)) fooAnnotations.add(elem);
        }

        if (fooAnnotations.size() > 0) {
            log("... but I am now going to process:" + fooAnnotations.toString());
            processInternal(fooAnnotations, roundEnv);
        } else {
            log("... but none of those was my business!");
        }

        // always return false so that other processors get a chance to process the annotations not consumed here
        return false;
    }

    private void processInternal(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        // TODO: do your foo processing here
    }

    private boolean isFoo(TypeElement elem) {
        if (elem.getQualifiedName().toString().equals("acme.annotation.FooEntity")
                || elem.getAnnotation(FooEntity.class) != null) {
            return true;            
        } else {
            return false;
        }
    }

}