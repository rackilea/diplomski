public class Column {
    private String name;
    private Class clazz;
    private Object value;

    public Column(String name, Class clazz, Object value) {
        this.name = name;
        this.clazz = clazz;
        this.value = value;
    }

    // ...
}