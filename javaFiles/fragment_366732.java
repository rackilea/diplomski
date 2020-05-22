@Usage("JDBC connection")
class jdbc {

  @Usage("connect to database with a JDBC connection string")
  @Command
  public String connect(
          @Usage("The username")
          @Option(names=["u","username"])
          String user,
          @Usage("The password")
          @Option(names=["p","password"])
          String password,
          @Usage("The extra properties")
          @Option(names=["properties"])
          Properties properties,
          @Usage("The connection string")
          @Argument
          String connectionString) {
     ...
  }

  @Usage("close the current connection")
  @Command
  public String close() {
     ...
  }
}

% jdbc connect jdbc:derby:memory:EmbeddedDB;create=true