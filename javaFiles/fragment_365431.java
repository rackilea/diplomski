final class Friend {
    private final int id;
    private final String firstName;
    private final String lastName;

    public Friend(int id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getInitials() {
        return String.valueOf(firstName.charAt(0)) + lastName.charAt(0);
    }

    public String getLetterHead() {
        return firstName.substring(0, 4);
    }
}