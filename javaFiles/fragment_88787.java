private static String[] createMoviesArray(Scanner scanner) {
    int count = 0;
    String[] movies; // = new String[500];
    while (scanner.hasNextLine()) {
        String line = scanner.nextLine();
        System.out.println(count + " : " + line);
        count += 1;
    }
    movies = new String[count]; // all you do here, is create an array with 'count' spaces, all default values (being null)
    return movies;
}