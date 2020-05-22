public static class UserDto {
    private final Name name;

    private UserDto(Name name) { this.name = name; }

    public static UserDto fromUser(User user) {
        return new UserDto(Name.fromUser(user));
    }

    public Name getName() { return name; }

    public static class Name {
        private final String first;
        private final String middle;
        private final String last;

        private Name(String first, String middle, String last) {
            this.first = first;
            this.middle = middle;
            this.last = last;
        }

        public static Name fromUser(User user) {
            return new Name(user.getFirst(), user.getMiddle(), user.getLast());
        }

        public String getFirst() { return first; }
        public String getMiddle() { return middle; }
        public String getLast() { return last; }
    }
}