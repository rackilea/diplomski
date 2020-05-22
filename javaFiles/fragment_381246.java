int hashCode() {
    int x = INITIAL_VALUE;
    for (Object o : this) {
        x = f(x, o==null ? NULL_HASH : g(o.hashCode()));
    }
    return h(x);
}