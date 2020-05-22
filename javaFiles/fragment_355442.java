public class City {

    private String route1;
    private String route2;

    private City(String route1, String route2) {
        this.route1 = route1;
        this.route2 = route2;
    }

    public String getRoute1() {
        return route1;
    }

    public String getRoute2() {
        return route2;
    }

    public Direction direction(int x, int y) {
        return new Direction(x + 2, y * 2);
    }

}