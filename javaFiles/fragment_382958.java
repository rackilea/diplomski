public class A {
    private A(int param1, String param2) {}

    public static A createFromCursor(Cursor c) {
        // calculate param1 and param2 from cursor
        return new A(param1, param2);
    }
}