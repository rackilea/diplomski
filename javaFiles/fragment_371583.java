public interface MyInterface<T> {
    T myMethod();
}

public class MyClassOne implements MyInterface<Void> {
    @Override
    public Void myMethod() {
        System.out.println("MyClassOne");
        return null;
    }
}

public class MyClassTwo implements MyInterface<String> {
     @Override
     public String myMethod() {
         System.out.println("MyClassTwo");
         return "MyClassTwo";
     }
}