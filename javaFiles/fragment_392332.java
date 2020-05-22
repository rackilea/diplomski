import java.lang.reflect.Field;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtField;
import javassist.bytecode.AnnotationsAttribute;
import javassist.bytecode.ClassFile;
import javassist.bytecode.ConstPool;
import javassist.bytecode.annotation.Annotation;

public class AddingAnnotationDynamically {
    public static void main(String[] args) throws Exception {
        ClassPool cp = ClassPool.getDefault();
        CtClass cc = cp.get("scala.Option");
        // Without the call to "makePackage()", package information is lost
        cp.makePackage(cp.getClassLoader(), pkgName);
        ClassFile cfile = cc.getClassFile();
        ConstPool cpool = cfile.getConstPool();

        AnnotationsAttribute attr =
                new AnnotationsAttribute(cpool, AnnotationsAttribute.visibleTag);
        Annotation annot = new Annotation(annotationName, cpool);
        attr.addAnnotation(annot);
        cfile.addAttribute(attr);
        // Changes are not persisted without a call to "toClass()"
        Class<?> c = cc.toClass();
    }
}