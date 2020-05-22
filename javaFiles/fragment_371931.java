private static final class Film {

    double rating;

    public double getRating() {
        return rating;
    }

    public Film setRating(double rating) {
        this.rating = rating;
        return this;
    }

    @Override
    public String toString() {
        return Double.toString(rating);
    }
}