public C max(C[] xs){
    return max(xs, Comparator.naturalOrder());
}

public C max(C[] xs, Comparator<? super C> c){
    C res = xs[0];
    for (int i = 1; i < xs.length; i++) {
        if (c.compare(xs[i], res) > 0) {
            res = points[i];
        }
    }
    return res;
}