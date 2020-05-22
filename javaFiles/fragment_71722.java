public class Shallow {
    private Object[] properties = new Object[2];

    public Shallow(String name, int number) {
        this.properties[0] = name;
        this.properties[1] = number;
    }

    public Shallow(Shallow s) {
        this.properties = s.properties;
    }

    public String getName() {
        return (String) properties[0];
    }

    public void setName(String name) {
        this.properties[0] = name;
    }

    public int getNumber() {
        return (Integer) properties[1];
    }

    public void setNumber(int number) {
        this.properties[1] = number;
    }
}