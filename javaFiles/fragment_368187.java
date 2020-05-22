public class Name {
  String firstName;
  String lastName;

  public String getFirstName() {
    return firstName();
  }
  public String getLastName() {
    return lastName();
  }
}

public void onChildAdded(DataSnapshot dataSnapshot, String s) {
    Name name = dataSnapshot.getValue(Name.class);
    System.out.println("First Name: " + name.getFirstName());
    System.out.println("Last Name: " +name.getLastName();
}