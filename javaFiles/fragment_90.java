public class Client {
    private int id;
    private String name;
    private String lname;

    public Client(int id, String name, String lname) {
        this.id = id;
        this.name = name;
        this.lname = lname;
    }

    public int getId() {
        return id;
    }

    public String toString() {
        return name + " " + lname;
    }
}