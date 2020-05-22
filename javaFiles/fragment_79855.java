final Lazy<X>[] a = new Lazy<X>[1];
final Lazy<Y>[] b = new Lazy<Y>[1];

a[0] = new Lazy<X>(() -> {
    List<Y> ys = new ArrayList<Y>();
    ys.add(b[0].getValue());
    return new X(ys);
});

b[0] = new Lazy<Y>(() -> {
    List<X> xs = new ArrayList<X>();
    xs.add(a[0].getValue());
    return new Y(xs);
});