@RequestScoped
private static class InsertName implements Callable<Boolean>
{
  private final Provider<String> name;
  private final Provider<Connection> connection;

  @Inject
  public InsertName(@Named("name") Provider<String> name, Provider<Connection> connection)
  {
    this.name = name;
    this.connection = connection;
  }

  @Override
  public Boolean call()
  {
    try
    {
      boolean nameAlreadyExists = ...;
      if (!nameAlreadyExists)
      {
        // insert the name
        return true;
      }
      return false;
    }
    finally
    {
      connection.close();
    }
  }
}