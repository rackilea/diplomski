class Subclass extends ParentClass {
    private String subclassField;

    Subclass() {
        super("bar");
        this.subclassField = "init"; // *** Note this moved
    }
}