class MyClass {
    private String firstName;
    private String lastName;
    public MyClass(String first, String last) {
        firstName = first;
        lastName = last;
    }
    public void CopyFrom(MyClass other) {
        firstName = other.firstName;
        lastName = other.lastName;
    }
}