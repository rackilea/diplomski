public class TestClass {
    public static void main(String[] args) {
        MyClass m = new MyClass();
        m.consumer.accept("bar2");
    }
}

class MyClass {
    final String foo;
    final Consumer<String> consumer;

    public MyClass() {
        consumer = getConsumer();
        // first call to illustrate the value that would have been captured
        consumer.accept("bar1");
        foo = "foo";
    }

    public Consumer<String> getConsumer() {
        return bar -> System.out.println(bar + foo);
    }
}