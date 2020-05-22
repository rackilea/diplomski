enum Vehicle {

    CAR        ("DRIVE!"),
    TRUCK      ("DRIVE!"),
    BUS        ("DRIVE!"),
    TRACTOR    ("DRIVE!"),
    MOTORCYCLE ("RIDE!"),
    BOAT       ("SAIL!"),
    AIRPLANE   ("PILOT!");

    private final String action;

    Vehicle(String action) {
        this.action = action;
    }

    public String action() {
        return action;
    }
}