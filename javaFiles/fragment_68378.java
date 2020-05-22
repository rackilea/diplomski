class Pair <T,U> {
    private T _t;
    private U _u;

    public Pair(T t, U u) {
        _t = t;
        _u = u;

    public String toString() {
        return _t + " " + _u;
    }
}