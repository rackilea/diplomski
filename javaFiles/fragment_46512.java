import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.constraints.Email;

 public class User {

    @NotNull(message = "Name cannot be null")
    private String name;

    @Size(min = 10, max = 200, message 
      = "About Me must be between 10 and 200 characters")
    private String aboutMe;

    @Min(value = 18, message = "Age should not be less than 18")
    @Max(value = 150, message = "Age should not be greater than 150")
    private int age;

    @Email(message = "Email should be valid")
    @NotNull
    private String email;

    // setters and getters 
}

@PutMapping(path="/update")
public ResponseEntity<UserResponse> updateUser(@Valid @RequestBody User user) {
    return userRepository.save(user);
}