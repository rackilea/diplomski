class Foo {
    private String name;

    Foo() {
        this.name = null;
    }

    Foo(Foo f) {
        this.name = f.name;
    }

    public void setName(String n) {
        this.name = n;
    }

    public Foo spawn() {
        return new Foo(this);
    }
}