public class DB {

  private static final Client client = new Client();

  public insert(Object data) {
    client.insert(data);  // Guaranteed to be initialized once class loading is complete.
  }
}