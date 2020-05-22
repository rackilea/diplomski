interface Transformer<A, B> {
    B transform(A a);
}

class ArrayUtils {
    @SuppressWarnings("unchecked")
    public static <A, B> B[] transformArray(
        Class<B> clazz,
        A[] a,
        Transformer<A, B> transformer
    ) {
        B[] b = (B[])Array.newInstance(clazz, a.length);
        for(int i = 0; i < a.length; i++) {
            b[i] = transformer.transform(a[i]);
        }
        return b;
    }
}