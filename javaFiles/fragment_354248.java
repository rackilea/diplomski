import java.lang.reflect.Method;


public class Example {

    public void exampleMethodNoParam() {
        System.out.println("No params");
    }

    public void exampleMethodWithParam(String arg) {
        System.out.println(arg);
    }

    public static void main(String[] args) throws Throwable {
        Example example = new Example();
        Method noParam = Example.class.getMethod("exampleMethodNoParam");
        Method stringParam = Example.class.getMethod("exampleMethodWithParam", String.class);
        noParam.invoke(example);
        stringParam.invoke(example, "test");
        //output 
        //No params
        //test
    }
}