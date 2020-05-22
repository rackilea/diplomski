class Test {
    public String toString() {
        return "test";
    }
}

class Generic<T> {
    private T element;

    Generic(T element) {
        this.element = element;
    }

    public String toString() {
        return element.toString();
    }
}

public class GenericTest {
    public static void main(String[] args) {
        Generic<Test> testGeneric = new Generic<Test>(new Test());
        System.out.println(testGeneric);

        Generic<Integer> integerGeneric = new Generic<Integer>(3);
        System.out.println(integerGeneric);
    }
}