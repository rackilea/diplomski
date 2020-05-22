public class Employee {

  private String record;
  private String firstName;
  private String lastName;
  private String title;
  private String filler;
  private int errorCount;
  private List<Error> error;

  public int getErrorCount() {
    return error != null ? error.size() : 0;
  }
  // getter/setters removed
}