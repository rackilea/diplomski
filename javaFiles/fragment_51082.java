public class Example {
    private static Something something;
    public void method() {
        if (something == null) something = new Something();
    }
}