public class Item {
  private String firstName;
  private String lastName;
  private int age;

  @JsonProperty("Name",access=Access.READ_ONLY)
  public String getName() {
    return(firstName + " " + lastName);
  }
}