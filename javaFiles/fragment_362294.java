public class Person {
  private String firstName;
  private String lastName;
  private String fullName;

  public Person(String firstName, String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.fullName = firstName + lastName;
  }

  public String getFirstName() { return firstName; }
  public String getLastName() { return lastName; }
  public String getFullName() { return fullName; }

  @Override
  public boolean equals(Object ob) {
    if (ob == null) return false;
    if (ob.getClass() != getClass()) return false;
    Person other = (Person)ob;
    if (!firstName.equals(other.firstName)) return false;
    if (!lastName.equals(other.lastName)) return false;
    if (!(fullName.equals(other.fullName)) return false;
    return true;
  }

  @Override
  public int hashCode() {
    return firstName.hashCode() ^ lastName.hashCode() ^ fullName.hashCode();
  }
}