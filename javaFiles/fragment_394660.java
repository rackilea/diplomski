static class A {
}

static class B extends A {
}

public static void main(String[] args) {

    Comparator<A> comparator = new Comparator<A>() {
        public int compare(A a1, A b2) {
            return 0;
        }
    };

    // TreeSet.TreeSet<B>(Comparator<? super B> c)
    SortedSet<B> set = new TreeSet<B>(comparator);

    // Comparator<? super B> comparator()
    set.comparator();
}