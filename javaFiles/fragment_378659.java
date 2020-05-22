public class Room {

    protected String roomNumber;
    protected int capacity;
    protected boolean projection;

    public Room(String rm, int n, boolean p) {
        roomNumber = rm;
        capacity = n;
        projection = p;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public int getCapacity() {
        return capacity;
    }

    public boolean hasProjector() {
        return projection;
    }

    public static void main(String[] args) {
        Room r = new ComputerLab("G102", 20, true, "WindowsXP");
        System.out.println(r.getCapacity());
    }
}

class ComputerLab extends Room {

    private String os;

    public ComputerLab(String rm, int n, boolean p, String os) {
        super(rm, n, p);
        this.os = os;
    }

    public String getOS() {
        return os;
    }

    public void setOS(String update) {
        os = update;
    }

}