import java.lang.reflect.*;
public class Main {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Field staticFieldMInt = Custom.class.getField("mInt"); // this can be argument
        Integer mInt = (Integer) staticFieldMInt.get(null); // null because it is a class property.
        System.out.println(mInt); // prints 10
    }
}

public class Custom {
    public static Integer mInt = 10; // this could be any type
}