import java.lang.reflect.Field;


public class Foo {

    char[] myChar;

    public static void main(String[] args) {
        for (Field field : Foo.class.getDeclaredFields()) {
            System.out.format("Name: %s%n", field.getName());
            System.out.format("\tType: %s%n", field.getType());
            System.out.format("\tGenericType: %s%n", field.getGenericType());
            if(char[].class.equals(field.getClass()))
            {
                System.out.println("Class match");
            }
            if(char[].class.equals(field.getType()))
            {
                System.out.println("Type match");
            }
        }
    }
}