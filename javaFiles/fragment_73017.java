class MyClass {
    int id;
    Optional<Double> value;

    MyClass(int id) {
        this.id = id;
        this.value = Optional.empty();
    }

    void setValue(double v) {
        value = Optional.of(v);
    }

    double getValue() {
        if (isValueUnassigned) {
            throw new RuntimeException("Value has not been assigned");
        }
        return value.get();
    }

    boolean isValueUnassigned() {
        return value.isEmpty();
    }
}