import sun.jvm.hotspot.oops.InstanceKlass;
import sun.jvm.hotspot.oops.Klass;
import sun.jvm.hotspot.oops.Method;
import sun.jvm.hotspot.runtime.VM;
import sun.jvm.hotspot.tools.Tool;

public class CheckMethodCall extends Tool {
    private static final String className = "java/util/HashMap";
    private static final String methodName = "get";
    private static final String methodSig = "(Ljava/lang/Object;)Ljava/lang/Object;";

    @Override
    public void run() {
        Klass klass = VM.getVM().getClassLoaderDataGraph().find(className);
        if (klass == null) {
            System.out.println("Class not found");
            return;
        }

        Method method = ((InstanceKlass) klass).findMethod(methodName, methodSig);
        if (method == null) {
            System.out.println("Method not found");
            return;
        }

        boolean called = method.getMethodCounters() != null &&
                method.getInvocationCount() + method.interpreterInvocationCount() > 0;
        System.out.println("Method " + (called ? "has been" : "has NOT been") + " called");
    }

    public static void main(String[] args) {
        new CheckMethodCall().execute(args);
    }
}