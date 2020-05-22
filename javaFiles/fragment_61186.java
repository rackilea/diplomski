import java.lang.reflect.*;

public class Test {

    public static void main(String[] args) {
        String[] original = new String[] { "x" };
        String[] x =  Test.<String>toArray(original);
    }

    public static <E> E[] toArray(E[] a) {
        E[] copy = (E[]) Array.newInstance(a.getClass().getComponentType(), a.length + 1);
        System.arraycopy(a, 0, copy, 0, a.length);
        return copy;
    }
}