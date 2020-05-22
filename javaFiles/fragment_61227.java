class Director {
  private static Director director;

  private Director() {
   ...
  }

  public static Director getInstance() {
    if (director == null)
      director = new Director();

    return director;
  }
}