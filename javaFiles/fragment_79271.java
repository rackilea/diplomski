class Pair<T> {
    final T a, b;

    public Pair(T a, T b) {
        this.a = a;
        this.b = b;
    }
    @Override
    public boolean equals(Object obj) {
        if(obj==this) return true;
        if(!(obj instanceof Pair)) return false;
        Pair<?> p=(Pair<?>)obj;
        return Objects.equals(this.a, p.a) && Objects.equals(this.b, p.b)
            || Objects.equals(this.a, p.b) && Objects.equals(this.b, p.a);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(a) + Objects.hashCode(b);
    }
}