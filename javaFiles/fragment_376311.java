import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class Main {

    public static void main(String args[]) throws Exception {

        // Just an example calling all the methods
        for (int i = 1; i < 100; i++) {

            Object object = invokeMethod("func", i);

            if (object != null) {
                // Do something with object, cast it, etc. ...
            } else {
                // Error calling the methods
            }

        }

    }

    private static Object invokeMethod(String methodBaseName, int number) {

        // Number format will be two digits padded by zeros,
        // e.g. 01, 02, ..., 18, ...
        // For three digits use "%03d" and so on or calculate
        // the digits from the number itself
        String methodName = methodBaseName + String.format("%02d", number);

        try {
            Method methodToInvoke = MethodClass.class.getMethod(methodName);
            return methodToInvoke.invoke(new MethodClass());
        } catch (NoSuchMethodException | SecurityException
            | IllegalAccessException | IllegalArgumentException
            | InvocationTargetException e) {
            // Alternatively handle this errors
            return null;
        }
    }
}

class MethodClass {

    public Object func01() {
        // ...
    }

    // ...

    public Object func99() {
        // ...
    }

}