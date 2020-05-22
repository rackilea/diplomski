public final class Example44 {
    public static void main(final String[] args) {
        System.out.println(new Util44<String>().compare("a", "b"));
        System.out.println(new Util44().compare(new String(""), new Long(1)));
    }
}

final class Util44<T> {
    private T aT;
    public boolean compare(T t1, T t2) {
        System.out.println(this.aT);
        // I was expecting the second and third assignments to fail
        // with the first invocation because T is explicitly a String
        // and then to work with the second invocation because I use
        // a raw type and the compiler must infer a common type for T.
        // Actually, all these assignments succeed with both invocation. 
        this.aT = (T) new String("z");
        this.aT = (T) new Long(0);
        this.aT = (T) new Object();
        return t1.equals(t2);
    }
}