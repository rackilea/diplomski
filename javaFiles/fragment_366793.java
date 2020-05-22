class Base {
    private String dataOfBase;
    ...
    public Base(Base other) {
        this.dataOfBase = other.dataOfBase;
    }

    @Override
    public Base clone() { // Covariant return type
        return new Base(this); // calling copy constructor
    }
}