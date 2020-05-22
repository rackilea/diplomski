public abstract class A<T extends A.B> {
    ...
    private List<T> b;

    public List<T> getB() {
        return b;
    }
    public void setB(List<T> b) {
        this.b = b;
    }
    public static abstract class B {
        ...
    }
}