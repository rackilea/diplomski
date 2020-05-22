public class ClassA {
    private final Object field1;
    private final Object field2;

    public ClassA(Object arg1, Object arg2) {
        this(calc1(arg1, arg2), calc2(arg1, arg2), true);
    }

    public ClassA(int arg1, String arg2, boolean arg3) {
        this(calc1(arg1, arg2, arg3), calc2(arg1, arg2, arg3), true);
    }

    private ClassA(Object arg1, Object arg2, boolean a) {
        field1 = arg1;
        field2 = arg2;
    }

    private static Object calc1(int arg1, String arg2, boolean arg3) {
        return ... // calculate value 1 based on args
    }

    private static Object calc2(int arg1, String arg2, boolean arg3) {
        return ... // calculate value 2 based on args
    }

    private static Object calc1(Object arg1, Object arg2) {
        return ... // calculate value 1 based on args
    }

    private static Object calc2(Object arg1, Object arg2) {
        return ... // calculate value 2 based on args
    }

}