public class User {

    @JsonBackReference
    public List<Role> roles;

    // ...       

}

public class Role {

    @JsonManagedReference
    public List<User> users;

    // ...       

}