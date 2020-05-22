@Subject("known users")
static class KnownUsers implements Question<List<ApplicationUser>> {

  public static KnownUsers inTheSystem() { return new KnownUsers(); }

  @Override
  public List<ApplicationUser> answeredBy(Actor actor) {
      // Query the database and convert the result set to ApplicationUsers
      return ...;
  }
}