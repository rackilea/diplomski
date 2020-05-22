public class MainClass {
    public static void main(String[] args) {
        Test obj = new Test();

        String x = "h";
        obj.testMethod(x);
        System.out.println(obj.m); // prints example1

        x = "f";
        obj.testMethod(x);
        System.out.println(obj.m); // prints example2
    }
}