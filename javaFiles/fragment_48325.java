public class Payment implements Serializable {
    private String name = "";
    private double value = 0;

    public Payment(String name, double value) {
        this.setName(name);
        this.setValue(value);
    }
...
}