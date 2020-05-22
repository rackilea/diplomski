Movie mockMovieWith(String title, Date releaseDate, ...) {
  Movie mockedMovie = createMock(Movie.class);
  expect(mockedMovie.getTitle()).andStubReturn(title);
  expect(mockedMovie.getReleaseDate())...
  replay(mockedMovie);
  return mockedMovie;
}