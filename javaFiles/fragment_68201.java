public class MyClass {
    String value;

    /* public, no-argument constructor */
    public MyClass() {
    }

    /* Every field has a public getter... */
    public String getValue(){
        return value;
    }

    /* ... and a public setter */
    public void setValue(String value) {
        this.value = value;
    }
}