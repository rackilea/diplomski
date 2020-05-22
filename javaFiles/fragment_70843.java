public class Test {

    private final String name;

    public Test(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        Test t = new Test("Jon");
        // Create an instance of NamePrinter with a reference to the new instance
        // as the enclosing instance.
        Runnable r = t.new NamePrinter();
        r.run();
    }    

    private class NamePrinter implements Runnable {
        @Override public void run() {
            // Use the enclosing instance's name variable
            System.out.println(Test.this.name);
        }
    }
}