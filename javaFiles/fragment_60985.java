public class SomeService {
  private SomeRepository repo;
  public SomeService(SomeRepository repo){
    this.repo = repo;
  }
  public YourClass save(YourClass clazz){
    repo.save(clazz);
  }
}

public class SomeRepository {
  private Connection yourDatabaseConnection;

  public YourClass save(YourClass clazz){
    yourDatabaseConnection.save(clazz);
  }
}