import java.lang.reflect.Constructor;

public class Test {
    public Test(String str) {
        System.out.println(str);
    }

    public Test(int a, int b) {
        System.out.println("Sum is " + (a + b));
    }

    public static void main(String[] args) throws Exception {
        Constructor<Test> constructorStr = Test.class.getConstructor(String.class);
        constructorStr.newInstance("Hello, world!");

        Constructor<Test> constructorInts = Test.class.getConstructor(int.class, int.class);
        constructorInts.newInstance(2, 3);
    }
}