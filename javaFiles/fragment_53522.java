public class Movie {

           private int rank;
    private String name;

    public Movie(int rank, String name) {
        this.rank = rank;
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public int getRank() {
        return rank;
    }
}