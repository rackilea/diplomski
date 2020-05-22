public class Customer {
  private String firstName;
  private String lastName;
  private String address;
  private String city;
  private String country;
  private Date date;


  public String getFirstName() {
    return firstName;
  }
  // getters for all fields

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }
  // setters for all fields

  public String toString() {
    return String.format("[%s, %s, %s, %s, %s, %s]", firstName,
             lastName, address, city, country, date);
  }
}