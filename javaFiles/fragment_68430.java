public class Super {
    private int id;
    private String name;

    public Super(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public Super(Super other) {
        this.id = other.id;
        this.name = other.name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}