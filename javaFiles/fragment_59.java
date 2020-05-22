public class MyObject{
    String id;
    int qty;

    public MyObject(String id, int qty) {
        this.id = id;
        this.qty = qty;
    }

    @Override
    public String toString() {
        return "MyObject{" +
                "id='" + id + '\'' +
                ", qty=" + qty +
                '}';
    }
}