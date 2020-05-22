public class HelloBuggyWorld {
    String test // missing a semicolon

    public static void main (String [] args) {
        System.out.println('Hello World!');  // should be double quoted
    }
}