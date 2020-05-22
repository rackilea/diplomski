@RequestScoped
private static class InsertName implements Callable<Boolean>
{
  private final String name;
  private final Connection connection;

  @Inject
  public InsertName(@Named("name") String name, Connection connection)
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