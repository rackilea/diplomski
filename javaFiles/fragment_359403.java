public interface TestSuite {

  abstract void setupRestAssuredForSuite();
  ...


  static SomeReturn setup()
  {
      Database database = new Database();
      ...
      return database;
  }

  static void teardown(SomeType foo)
  {
      foo.reset();
  }
}