package mypackage;

public class MyClass {
    public static void main(String[] args) {
        java.net.URL url = MyClass.class.getResource("/mypackage/image.gif");
        System.out.println(url);
    }
}