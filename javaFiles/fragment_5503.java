public enum TestEnum {
    ONE("One at " + System.nanoTime()),
    TWO("Two at " + System.nanoTime());

    String value;

    TestEnum(String value) {
        System.out.println(value);
        this.value = value;
    }
}

public class Test {
    public static void main(String[] args) throws Exception {
        System.out.println("Loading");

        Class.forName("TestEnum"); // Load class

        System.out.println("Evaluating");

        System.out.println(TestEnum.ONE.value); // Evaluate value one
        System.out.println(TestEnum.TWO.value); // Evaluate value two
    }
}