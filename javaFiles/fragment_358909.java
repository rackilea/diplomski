import java.lang.reflect.Method;

public class ReflectionCalls {
    public static void main(String[] args) {
        new ReflectionCalls();
    }

    public ReflectionCalls() {
        callMethod(true);
        callMethod(false);
    }

    private void callMethod(boolean isInstanceMethod) {

        String className = "DiscoveredClass";
        String staticMethodName = "methodStatic";
        String instanceMethodName = "methodInstance";
        Class<?>[] formalParameters = { int.class, String.class };
        Object[] effectiveParameters = new Object[] { 5, "hello" };
        String packageName = getClass().getPackage().getName();

        try {
            Class<?> clazz = Class.forName(packageName + "." + className);

            if (!isInstanceMethod) {
                Method method = clazz.getMethod(staticMethodName, formalParameters);
                method.invoke(null, effectiveParameters);
            }

            else {
                Method method = clazz.getMethod(instanceMethodName, formalParameters);
                Object newInstance = clazz.newInstance();
                method.invoke(newInstance, effectiveParameters);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}