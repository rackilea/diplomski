public class Outer {
    class Inner {

    }

    public Inner inner = new Inner();

    public static void main(String... args) {
        Outer o1 = new Outer();
        Outer o2 = new Outer();

        System.out.println(o1.inner == o2.inner);
        System.out.println(o1.inner.getClass() == o2.inner.getClass());
    }

}