import java.lang.reflect.Field;
import sun.misc.Unsafe;

public class Example {
    private String value = "42";
    public static void main(String[] args) throws Exception {
        Example instance = (Example) unsafe.allocateInstance(Example.class);
        System.out.println(instance.value);
    }

    static Unsafe unsafe;
    static {
        try {

            Field singleoneInstanceField = Unsafe.class.getDeclaredField("theUnsafe");
            singleoneInstanceField.setAccessible(true);
            unsafe = (Unsafe) singleoneInstanceField.get(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}