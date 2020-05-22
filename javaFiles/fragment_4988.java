public class PopularityComparator implements Comparator<Movie> {
@Override
public int compare(Movie m1, Movie m2) {
    return Double.compare(m2.getPopularity(), m1.getPopularity());
}
}