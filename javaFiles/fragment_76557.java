public class Circle extends Shape {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean compare(String name) {
        if (this.name.equals(name)) {
            return true;
        }
        return false;
    }
}