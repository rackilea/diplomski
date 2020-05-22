public class B {
    private A<? extends A> a;

    public <T extends A<T>> void setA(T a) {
        this.a = a;
    }
}