class Test {
    public int getX() {
        return 10;
    }
    public void foo() {
        System.out.println("Test foo called " + getX());
    }
    ...

class ChildTest extends Test {
    @Override
    public int getX() {
        return 20;
    }
    ...