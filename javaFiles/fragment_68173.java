public class Person {

    private String Username;
    private String Email;

    public Person(String email,String userName) {
     this.Username=userName;
     this.Email=email;

      /*Blank default constructor essential for Firebase*/
    }
    //Getters and setters
    public String getUsername() {
        return Username;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }
}