@Guarded(checkInvariants = false)// removing this results in StackOverflowError
public class User {
    private final String firstName;
    private final String lastName;
    @NotNull(when = "groovy:_this.lastName != null")
    private final Integer age;

    @PostValidateThis
    public User(String firstName, String lastName, Integer age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Integer getAge() {
        return age;
    }
}