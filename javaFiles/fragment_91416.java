public class Foo<T> {
    void someMethod() {
        List<Point> points = new ArrayList<Point>();
        ... // add three points to the list
    }
    class Point {
        float x, y;
    }
}