public class MyClass {
    private String name;
    private String[] subclass;

    public MyClass() {}

    public MyClass(String name, String[] subclass) {
        this.name = name;
        this.subclass = subclass;
    }

    public String getName() { return name; }

    public String[] getSubclass() { return subclass; }
}