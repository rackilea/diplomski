public class SomeTest {

    static int staticVariable;
    int instanceVariable;        

    // Static initialization block:
    static {
        System.out.println("Static initialization.");
        staticVariable = 5;
    }

    // Instance initialization block:
    {
        System.out.println("Instance initialization.");
        instanceVariable = 10;
    }

    // Constructor
    public SomeTest() {
        System.out.println("Constructor executed.");
    }

    public static void main(String[] args) {
        new SomeTest();
        new SomeTest();
    }
}