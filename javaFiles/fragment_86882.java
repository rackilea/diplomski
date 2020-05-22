class Person {
    private String firstName;
    private String lastName;

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    /**
     * Returns a person's full name (first and last name), without
     * storing it as a seperate variable internally.
     */
    public String getName() {
         return this.firstName + " " + this.lastName;
    }

    public String getFirstName() {
         return this.firstName;
    }

    // etc.
}