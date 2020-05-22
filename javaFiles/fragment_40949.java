import java.lang.reflect.Method;

public class Dummy {

    public static void main(String[] args) throws Exception {
        System.out.println(new Dummy().f("t", 5));
    }

    double t(Double x) {
        return x * x;
    }

    double f(String name, double x) throws Exception {
        double d = -1;
        Method method;
        Class<?> enclosingClass = getClass();
        if (enclosingClass != null) {
            method = enclosingClass.getDeclaredMethod(name, Double.class);
            try {
                Object value = method.invoke(this, x);
                d = (Double) value;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return d;
    }
}