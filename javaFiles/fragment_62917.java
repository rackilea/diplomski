public class UserResponse {
    private String firstName;
    private String lastName;

    public UserResponse(User user){
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
    }

    ...
    //The getters
}