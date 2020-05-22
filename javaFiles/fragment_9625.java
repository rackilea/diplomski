public class TestClass {
    public final String hallo;
    public static final String halloSecond = "Saluto!";

    TestClass(String hello){
        String hallo = hello;
    }

    public static void main(String[] args) {
        TestClass test = new TestClass("Tjena!");
        System.out.println("I want "Tjena!": " + test.hallo);
        TestClass testSecond = new TestClass("1");
        System.out.println("I want Saluto!:" + test.halloSecond);
        System.out.println("I want Saluto!:" + testSecond.halloSecond);
    }
}