public class NullPassing {
    public static void main(String[] args) {
        method1(null);
    }
    public static void method1(Exception e) {
        System.out.println(e);
    }
    public static void method1(ArithmeticException e) {
        System.out.println(e);
    }
    public static void method1(NullPointerException e) {
        System.out.println(e);
    }  
}