public static void main(String[] args) {

    Set<Movie> movies = new HashSet<Movie>();
    movies.add(new Movie(0.6f));
    movies.add(new Movie(0.5f));
    movies.add(new Movie(0.7f));
    movies.add(new Movie(0.2f));

    // Movie.class has to implement Comparable
    System.out.println("First option:");
    List<Movie> list = new ArrayList<Movie>(movies);
    Collections.sort(list);
    printMovies(list);

    // Works without implementing Comparable in Movie.class
    System.out.println("\nSecond option:");
    List<Movie> secondList = new ArrayList<Movie>(movies);
    Collections.sort(secondList, new Comparator<Movie>() {
        public int compare(Movie movie1, Movie movie2) {
            return movie2.getRating().compareTo(movie1.getRating());
        }
    });
    printMovies(secondList);

}

private static void printMovies(List<Movie> list) {
    for (Movie movie : list) {
        System.out.println(movie);
    }
}