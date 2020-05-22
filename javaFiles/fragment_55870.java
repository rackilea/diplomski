abstract class Numeric<T extends Number> {
    public abstract T getValue();

    public abstract Numeric<T> add(Numeric<T> other);

    @Override
    public String toString() {
        return getValue().toString();
    }
}

class MyInt extends Numeric<Integer> {
    public final Integer value;

    public MyInt(Integer _value) {
        super();
        this.value = _value;
    }

    @Override
    public Integer getValue() {
        return this.value;
    }

    @Override
    public Numeric<Integer> add(Numeric<Integer> other) {
        return new MyInt(this.value + other.getValue());
    }
}

class MyDouble extends Numeric<Double> {
    public final double value;

    public MyDouble(Double _value) {
        super();
        this.value = _value;
    }

    @Override
    public Double getValue() {
        return this.value;
    }

    @Override
    public Numeric<Double> add(Numeric<Double> other) {
        return new MyDouble(this.value + other.getValue());
    }
}