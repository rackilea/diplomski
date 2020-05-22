import java.lang.reflect.Constructor;

public class Example1 {
    public Example1() {
    }

    public Example1(String s) {
        System.out.println("using param = " + s);
    }

    public static void main(String[] args) throws Exception {  
        Constructor<Example1> ctor = Example1.class.getConstructor(String.class.getClasses());
        ctor.newInstance("test");
    }
}