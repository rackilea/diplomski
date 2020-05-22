public class Player {
    private final String name;
    private final int attendance;

    public Player(String name, int attendance) {
        this.name = name;
        this.attendance = attendance;
    }

    public String getName() {
        return name;
    }

    public int getAttendance() {
        return attendance;
    }
}