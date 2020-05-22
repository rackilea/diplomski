public class HelloTest {
    public static void main(String[] args) {
        HelloTest test = new HelloTest();
        System.out.println(test.helloName("Bob"));
    }
    public String helloName(String input) {
        return "Hello " + input + "!";
    }
}