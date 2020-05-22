public class DoubleNameValuePair implements NameValuePair {

    String name;

    double value;

    public DoubleNameValuePair(String name, double value) {
        this.name = name;
        this.value = value;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getValue() {
        return Double.toString(value);
    }

}