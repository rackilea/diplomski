public class WrappedString {
    private final String str = "hello";
}

public void foo() {
    WrappedString ws1 = new WrappedString();
    WrappedString ws2 = new WrappedString();
    System.out.println(ws1.equals(ws2));
}