static void test(Object[] a) {
    Double[] dummy = Arrays.copyOf(a, a.length, Double[].class);
    System.out.println(dummy[0]); // prints 42.0
}

public static void main (String[] args)
{
    Object[] a = new Object[1];
    a[0] = new Double(42.0);
    test(a);
}