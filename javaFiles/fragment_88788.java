private static List<String> createMoviesArray(Scanner scanner) {
    List<String> movies = new ArrayList<>();
    while (scanner.hasNextLine()) {
        movies.add(scanner.nextLine());
    }
    return movies;
}