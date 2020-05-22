public static class HasDataBaseState {
  @ClassRule
  public static DataBaseState dbState = new DataBaseState();

  @Test
  public void testUsingDataBaseState() throws IOException {
    // perform tests
    dbState.query("select count from table where attribute = 'x'");
  }
}