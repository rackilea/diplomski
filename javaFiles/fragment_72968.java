enum Vehicle {

    CAR,
    TRUCK,
    BUS,
    TRACTOR,
    MOTORCYCLE {
        public String action() { return "RIDE!"; }
    },
    BOAT {
        public String action() { return "SAIL!"; }
    },
    AIRPLANE {
        public String action() { return "PILOT!"; }
    };

    public String action(){
        return "DRIVE!";
    }
}