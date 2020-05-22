public class Main {

public static void main(String... args) throws Exception {
    String json = 
        "{"
            + "'status' : 'success',"
            + "'data' : [{"
                + "'boxnumber' : '1',"
                + "'quantity' : 1,"
                + "'product' : '7010501264',"
                + "'packdate' : '2014-10-16 20:59:25.632533'"
                + "}]" 
        + "}";

    // Now do the magic.
    Gson gson = new GsonBuilder().create();
    YourObject data = gson.fromJson(json, YourObject.class);

    // Show it.
    System.out.println(data);
}

}
class YourObject {
    private String status;
    private List<Data> data;

    // getter and setter !!

    @Override
    public String toString() {
        return "YourObject [status=" + status + ", data=" + data + "]";
    }

}
class Data {
    private String boxnumber;
    private int quantity;
    private long product;
    private String packdate;

    // getter and setter

    @Override
    public String toString() {
        return "Data [boxnumber=" + boxnumber + ", quantity=" + quantity
                + ", product=" + product + ", packdate=" + packdate + "]";
    }