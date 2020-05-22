public class OuterClass {
    public static String string = "helloworld";

    public class InnerClass {
        string = "lol";
    }

    public static void main(String[] args) {
        System.out.println(string);
    }
}