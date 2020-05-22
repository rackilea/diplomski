import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectionExample {

    public static void main(String[] args)
            throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        ReflectionExample example = new ReflectionExample();
        example.print();
    }

    public void print() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        String nameOfTheMethod = "display";

        // primitive param call
        short s = 10;
        Method method = A.class.getDeclaredMethod(nameOfTheMethod, getType(s)); // invoke getType(short s)
        method.invoke(new A(), s); 

        // object param call
        Short sWrapper = 10;// Assume primitive type is short
        method = A.class.getDeclaredMethod(nameOfTheMethod, getType(sWrapper)); // invoke getType(Object o)
        method.invoke(new A(), sWrapper);
    }

    public Class<?> getType(short s) {
        return short.class;
    }

    public Class<?> getType(int i) {
        return int.class;
    }
    ... //

    public Class<?> getType(Object o) {
        return o.getClass();
    }

}