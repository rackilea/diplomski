ArrayList<Movie> movies = new ArrayList<Movie>();

while (rs.next())
{
    Movie movie = new Movie();

    movie.setId(rs.getInt("movie_id"));
    movie.setMovieName(rs.getString("movie_name"));
    movie.setDescription(rs.getString("description"));
    movies.add(movie);
}