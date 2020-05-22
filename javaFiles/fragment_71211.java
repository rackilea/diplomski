while (scan.hasNextLine()) {
    String line = scan.nextLine();
    movieList.add(line);
    movies += (line + "\n");
    numOfMovies++;
    randomMovie = (int) (Math.random() * numOfMovies);
}