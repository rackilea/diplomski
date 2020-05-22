private final A method_A = new A() {
    @Override
    public void apply(String name, int i, int j) {
        EnclosingClass.this.methodOne(name, i, j);
    }
};