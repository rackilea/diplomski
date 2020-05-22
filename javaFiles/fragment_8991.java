public class Interest {
    private int dangerRating;
    private String name;

    public Interest (int dangerRating, String name) {
        this.dangerRating = dangerRating;
        this.name = name;
    }

    public int getDangerRating() {
        return dangerRating;
    }

    public String getName() {
        return name;
    }
}