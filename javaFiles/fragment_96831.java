import sun.jvm.hotspot.oops.InstanceKlass;
import sun.jvm.hotspot.oops.Method;
import sun.jvm.hotspot.runtime.VM;
import sun.jvm.hotspot.tools.Tool;

public class CheckMethodCall extends Tool {
    private static final String className = "java/util/HashMap";
    private static final String methodName = "get";
    private static final String methodSig = "(Ljava/lang/Object;)Ljava/lang/Object;";

    @Override
    public void run() {
        boolean[] result = new boolean[2];

        VM.getVM().getSystemDictionary().classesDo(klass -> {
            if (klass.getName().asString().equals(className)) {
                Method method = ((InstanceKlass) klass).findMethod(methodName, methodSig);
                if (method != null) {
                    result[0] = true;
                    result[1] = method.getMethodCounters() != null &&
                        method.getInvocationCount() + method.interpreterInvocationCount() > 0;
                }
            }
        });

        if (!result[0]) {
            System.out.println("Method not found");
        } else if (result[1]) {
            System.out.println("Method has been called");
        } else {
            System.out.println("Method has NOT been called");
        }
    }

    public static void main(String[] args) {
        new CheckMethodCall().execute(args);
    }
}