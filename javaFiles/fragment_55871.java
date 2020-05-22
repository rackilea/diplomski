class NumericPoint<T extends Number> {
    public final Numeric<T> x;
    public final Numeric<T> y;

    public NumericPoint(Numeric<T> _x, Numeric<T> _y) {
        super();
        this.x = _x;
        this.y = _y;
    }

    public NumericPoint<T> add(NumericPoint<T> other) {
        return new NumericPoint<T>(this.x.add(other.x), this.y.add(other.y));
    }

    @Override
    public String toString() {
        return "(" + this.x + "/" + this.y + ")";
    }
}