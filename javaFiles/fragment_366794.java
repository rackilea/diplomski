class Derived extends Base {
    private String dataOfDerived;
    ...
    public Derived(Derived other) {
        super(other);
        this.dataOfDerived = other.dataOfDerived;
    }

    @Override
    public Derived clone() {
        return new Derived(this);
    }
}