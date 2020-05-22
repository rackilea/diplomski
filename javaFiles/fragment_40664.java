@Data
@Builder
@Accessors(fluent = true) // <— This is what you want
public class User {
    private final String firstName;
    private final String lastName;
    private final int age;
}