public class Main {
    private static final String HELLO = "hello";
    private static final String WORLD = "world";

    private static void goodMethod(){
        System.out.println(HELLO);
        System.out.println(WORLD);
    }

    private static void badMethod(){
        System.out.println("hello");
        System.out.println("world");
    }
}