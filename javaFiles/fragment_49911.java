public class Test {
    private final AtomicInteger a;
    // + constructor setting a + getter

    public void increment() {
        a.incrementAndGet();
    }

}

public class Main {
    public static void main(String[] args) {
        AtomicInteger i = new AtomicInteger()
        Test a = new Test(i);
        Test b = new Test(i);

        System.out.println(i.get()); // prints 0
        a.increment();
        System.out.println(i.get()); // prints 1
        b.increment();
        System.out.println(i.get()); // prints 2

    }
}