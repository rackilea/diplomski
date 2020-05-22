public MovieAdapter(List<Movie> movies, int rowLayout, Context context) {
    this.movies = movies;
    this.rowLayout = rowLayout;
    this.context = context;
    listener = (MovieAdapterListener) context;  //add this

}