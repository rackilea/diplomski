class Seat {

    private final String name;
    private final Type type;
    private boolean reserved = false;

    public Seat(String name, Type type) {
        this.name = name;
        this.type = type;
    }

    // ...Getters & Setters...

    public enum Type {
        Business,
        Economy;
    }
}

class BoeingSeatMap {
    private Seat[][] seats;

    public static final int rows = 10;
    public static final int collumns = 7;

    private static final String[] letters = { "A", "B", "C", "D", "E", "F", "G" };

    public void intializeSeatMap() {
        seats = new Seat[rows][collumns];

        for (int x = 0; x < seats.length; x++) {
            for (int y = 0; y < seats[x].length; y++) {
                String name = (x + 1) + letters[y];
                if(x < 4) { // first 4 rows are Business
                    seats[x][y] = new Seat(name, Seat.Type.Business);
                } else { // The rest Economy
                    seats[x][y] = new Seat(name, Seat.Type.Economy);
                }               
            }
        }
    }
}