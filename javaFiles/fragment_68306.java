public class Aggregate implements TabSerializable{
    private String data;

    @Override
    public String toTabbedString() {
        return data;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}