public class DB {
  private static class Holder {
    private static final Client client = new Client();
  }

  public insert(Object data) {
    Holder.client.insert(data);  // Holder.client is initialized on first access.
  }
}