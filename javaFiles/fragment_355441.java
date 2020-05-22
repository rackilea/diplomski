public enum City {
    NEW_YORK("U", "C"),
    LOS_ANGELES("U", "C");

    private String route1;
    private String route2;

    private Cities(String route1, String route2) {
        this.route1 = route1;
        this.route2 = route2;
    }

    public Direction direction(int x, int y) {
        return new Direction(x + 2, y * 2);
    }

}