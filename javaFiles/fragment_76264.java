public class Test<Data> {
    Comparator<Data> c;

    public Test(Comparator<Data> comparator) {
        System.out.println("Comparator");
        this.c = comparator;
    }

    public static <T extends Comparable<? super T>> Test<T> createWithComparable() {
        System.out.println("Comparable");
        return new Test<T>(new Comparator<T>() {
            @Override
            public int compare(T p1,T p2) {
                return p1.compareTo(p2);
            }
        });
    }
}