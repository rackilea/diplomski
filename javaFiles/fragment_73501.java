public class AccessTest {
    public int publicNumber;
    private int secretNumber;
}

public class Client {
    public static void main(String[] args) throws Exception {
        reflection();
        noReflection();
    }

    private static void noReflection() throws IllegalAccessException, NoSuchFieldException {
        int a = new AccessTest().publicNumber;
          //                     ^^^^^^^^^^^^ 
          // To be changed to secretNumber in bytecode editor after compilation

        System.out.println("Number read: " + a);
    }

    private static void reflection() throws IllegalAccessException, NoSuchFieldException {
        AccessTest instance = new AccessTest();
        AccessTest.class.getDeclaredField("publicNumber").get(instance); // <-- Works
        try {
            AccessTest.class.getDeclaredField("secretNumber").get(instance); // <-- Throws IllegalAccessException
        } catch (IllegalAccessException e) {
            System.out.println("Caught IllegalAccessException");
        }
    }
}