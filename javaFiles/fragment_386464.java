import java.util.*;

import org.objectweb.asm.commons.EmptyVisitor;

public class MyMethodVisitor extends EmptyVisitor {

    private String currentMethod;
    private Map<String, Set<String>> callMap;

    public MyMethodVisitor(String currentMethod,
            Map<String, Set<String>> callMap) {
        this.currentMethod = currentMethod;
        this.callMap = callMap;
    }

    @Override
    public void visitMethodInsn(int opcode, String owner, String name,
            String desc) {

        String calledMethod = owner + "." + name;

        Set<String> callers = callMap.get(calledMethod);
        if (callers == null) {
            callers = new TreeSet<String>();
            callMap.put(calledMethod, callers);
        }

        callers.add(currentMethod);
    }
}