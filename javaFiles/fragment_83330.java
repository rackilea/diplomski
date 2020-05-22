@Test(expected = RuntimeException.class)
public void letSetMovieFailByNullMovie() {
    Rental rental = new Rental();
    Movie nullMovie = null;
    rental.setMovie(nullMovie);
}