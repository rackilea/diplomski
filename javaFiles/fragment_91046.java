class Person {
    public static final String PERSON_TO_STRING_FORMAT = "{f: %s, l: %s}";

    private final String firstName;
    private final String lastName;

    private Person(final String firstName, final String lastName) {
        this.firstName = Objects.requireNonNull(firstName);
        this.lastName = Objects.requireNonNull(lastName);
    }

    public static Person of(final String firstName, final String lastName) {
        return new Person(firstName, lastName);
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return String.format(PERSON_TO_STRING_FORMAT, getFirstName(), getLastName());
    }
}