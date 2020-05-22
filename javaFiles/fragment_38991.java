public class DataWrapper {
    String data;
    Object source;

    public DataWrapper(String data, Object source) {
        super();
        this.source = source;
        this.data = data;
    }

    public String getData() {
        return data;
    }
    public Object getSource() {
        return source;
    }
}