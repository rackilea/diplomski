import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class field1 {
    private double d;
    public static final int i = 37;
    String s = "testing";

    public static void main(String args[]) {
        field1 f = new field1();

        try {
            Class cls = Class.forName("field1");

            Field fieldlist[] = cls.getDeclaredFields();
            for (Field field : fieldlist) {
                System.out.println("name = " + field.getName());
                System.out.println("decl class = " + field.getDeclaringClass());
                System.out.println("type = " + field.getType());

                int mod = field.getModifiers();
                System.out.println("modifiers = " + Modifier.toString(mod));
                System.out.println("value = " + field.get(f));
                System.out.println("-----");
            }
        } catch (Throwable e) {
            System.err.println(e);
        }
    }
}