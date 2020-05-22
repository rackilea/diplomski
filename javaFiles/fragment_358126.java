public class Movie
{
  private String movieName;
  private String trailerUrl;

  public void setMovieName ( String movieName ) 
  {
    this.movieName = movieName;
  }

  public void setTrailerUrl ( String trailerUrl) 
  {
    this.trailerUrl= trailerUrl;
  }

  public void getMovieName () 
  {
    return movieName;
  }

  public void getTrailerUrl () 
  {
    return trailerUrl;
  }

}