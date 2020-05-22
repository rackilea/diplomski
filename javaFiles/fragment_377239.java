for (int i = 0; i < array.length(); i++) {
    JSONObject jsonMovie = array.getJSONObject(i);
    MovieModel movieModel= new MovieModel();
    movieModel.setMovieTitle(jsonMovie.getString("title"));
    movieModel.setMovieGenre("na");
    String strImgURL=jsonMovie.getString("poster_path").substring(2);
    movieModel.setImgURL("");
    movieModel.setMovieYear(jsonMovie.getString("release_date"));
    results.add((movieModel));
}