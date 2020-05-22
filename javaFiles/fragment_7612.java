public class ImmutablePerson {
    private static final int MAX_LAST_NAME_LENGTH = 255; // belongs to the type
    private final String firstName; // belongs to the instance
    private final String lastName; // belongs to the instance

    public ImmutablePerson(String firstName, String lastName) {
        if (lastName.length() > MAX_LAST_NAME_LENGTH) {
            throw new IllegalArgumentException("last name too large");
        }
        this.firstName = firstName;
        this.lastName = lastName;
    }

    // getters omitted for brevity
}