protected class MovieTask extends AsyncTask<Void, Void, MovieDB> {

    protected MovieDB doInBackground(Void... v) {
        TmdbMovies movies = new TmdbApi("myAPIkey_here").getMovies();
        MovieDb movie = movies.getMovie(5353, "en");
        return movie;
    }

    protected void onPostExecute(MovieDB movie) {
        // Do something with movie
    }
}