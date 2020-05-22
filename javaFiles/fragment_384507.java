class Person {
    private String name;
    private String phone;
    private String email;
    // Add getters and setters.
}

@WebMethod
public Person getPerson(String someInputParam) {
    Person p = new Person();
    // Populate person
    return p;
}