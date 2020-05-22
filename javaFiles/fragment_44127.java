enum Foo {
    QUX;

    private static int idIncrementor = 0;
    private int id;

    Foo() {
        this.id = idIncrementor++;
    }

    public int getId() {
        return id;
    }
}