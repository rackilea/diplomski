class ParentClass {
    ParentClass(String s) {
    }
}

class Subclass extends ParentClass {
    private String subclassField = "init";

    Subclass() {
        super("bar");
    }
}