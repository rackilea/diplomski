public class User {
//@Id
//private String id;
private String firstName;
private String lastName;

public User(String firstName, String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
}

public User() {
   }

// public String getId() {
//     return id;
// }

public String getFirstName() {

    return firstName;
}

public String getLastName(){

    return lastName;
    }

 }