import java.lang.reflect.*;

class Super<T> {
    public void method (T t) {
        System.out.println("Hello");
    }

    public void method2 () {

    }
}

public class Test extends Super {
    /*public void method (Object t) {
        System.out.println("world");
    }*/

    /*public <T> void method (T t) {

    }*/

    public static void main (String args[]) {
        new Test().method("");
        for (Method m : Test.class.getMethods()) {
            System.out.println(m.toGenericString());
        }
    }
}