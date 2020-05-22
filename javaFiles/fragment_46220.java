public class Person implements Serializable {
    private String name;
    public String getName() {
        return name;
    }
    public Object foo() {
        return "bar";
    }
}