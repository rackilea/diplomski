import java.lang.reflect.Field;

public class Test {
    public static void main(String[] args) throws IllegalAccessException {
        SubClass subClass = new SubClass();
        subClass.a = 10;
        subClass.b = 10;

        SuperClass superClass = new SuperClass();
        superClass.c = 30;

        for (Field field : SuperClass.class.getDeclaredFields()) {
            field.set(subClass, field.get(superClass));
        }

        System.out.println(subClass.c); // prints out 30
    }

}

class SubClass extends SuperClass {
    int a;
    int b;
}

class SuperClass {
    int c;
}