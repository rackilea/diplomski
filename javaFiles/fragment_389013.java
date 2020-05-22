class Triple<T extends Number & Comparable> {
    T a;
    T b;
    T c;

    public Triple(T a, T b, T c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    double max() {
        if (a.compareTo(b) > 0 && a.compareTo(c) > 0) {
            return a.doubleValue();
        } else {
            if (b.compareTo(c) > 0) {
                return b.doubleValue();
            } else {
                return c.doubleValue();
            }
        }
    }

}


public class Main {

    public static void main(String[] args)  {
        Triple<Integer> triple = new Triple<>(1, 2, 3);

        System.out.println(triple.max());

    }
}