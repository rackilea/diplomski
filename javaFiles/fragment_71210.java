ArrayList<String> movieList = new ArrayList<String>();

while (scan.hasNextLine()) {
    movieList.add(scan.nextLine());
}

while (scan.hasNextLine()) {
    String line = scan.nextLine();
    movies += (line + "\n");
    numOfMovies++;
    randomMovie = (int) (Math.random() * numOfMovies);
}