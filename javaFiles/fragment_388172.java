abstract class Parent {
    public abstract String getACONSTANT();
}

class Child extends Parent {
    public static final String ACONSTANT = "some value";
    public String getACONSTANT() { return ACONSTANT; }
}