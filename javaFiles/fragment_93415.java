public class CustomId {

    private Object id;

    public CustomId(Object id) {
        this.id = id;
    }

    public String  toString() {
        return id.toString();
    }
    public Long  toLong() {
        return Long.valueOf(id.toString());
    }
}