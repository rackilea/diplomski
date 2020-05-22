public class Movie implements Comparable<Movie> {

    private Float rating;

    public Movie(Float rating) {
        this.rating = rating;
    }

    public Float getRating() {
        return rating;
    }

    public int compareTo(Movie param) {
        return param.getRating().compareTo(rating);
    }

    @Override
    public String toString() {
        return String.valueOf(rating);
    }
}