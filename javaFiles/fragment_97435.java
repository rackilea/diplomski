import java.lang.reflect.Field;

public class Test {
    public static void main(String... args) {
        try {
            Foobar foobar = new Foobar("Peter");
            System.out.println("Name: " + foobar.getName());
            Class<?> clazz = Class.forName("com.csa.mdm.Foobar");
            System.out.println("Class: " + clazz);
            Field field = clazz.getDeclaredField("name");
            field.setAccessible(true);
            String value = (String) field.get(foobar);
            System.out.println("Value: " + value);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class Foobar {
    private final String name;

    public Foobar(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}