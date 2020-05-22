class Name{
    private String firstName;
    private String lastName;

    public Name(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "{" + firstName + ", " + lastName
                + "}";
    }
    // Getters & Setters
}

public class Sample {

    public static void main(String[] args) throws JsonProcessingException {
        List<Name> names = new ArrayList<Name>(Arrays.asList(new Name[] { new Name("George","Hampton"), new Name("Marc", "Empten"), new Name("Levin", "Lian")}));
        System.out.println(names.get(1)); // Prints {Marc, Empten}

    }
}