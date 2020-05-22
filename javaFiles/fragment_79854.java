Lazy<X> a;
Lazy<Y> b;

a = new Lazy<X>(() -> {
    List<Y> ys = new ArrayList<Y>();
    ys.add(b.getValue());
    return new X(ys);
});

b = new Lazy<Y>(() -> {
    List<X> xs = new ArrayList<X>();
    xs.add(a.getValue());
    return new Y(xs);
});