import java.util.*;

import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.commons.EmptyVisitor;

public class MyClassVisitor extends EmptyVisitor {

    private String className;
    private Map<String, Set<String>> callMap;

    public MyClassVisitor(Map<String, Set<String>> callMap) {
        this.callMap = callMap;
    }

    @Override
    public void visit(int version, int access, String name, String signature,
            String superName, String[] interfaces) {
        this.className = name;
    }

    @Override
    public MethodVisitor visitMethod(int access, String name, String desc,
            String signature, String[] exceptions) {

        return new MyMethodVisitor(className + "." + name, callMap);
    }
}