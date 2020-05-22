class Student {
    private String name;
    private String address;

    public int hashCode() {
        // Assuming 'name' and 'address' are not null, for simplification here.

        return name.hashCode() + address.hashCode();
    }

    public boolean equals (Object other) {
        if (!(other instanceof Student) {
            return false;
        }
        if (other == this) {
            return true;
        }

        Student otherStudent = (Student) other;
        return name.equals(otherStudent.name) && address.equals(otherStudent.address);
    }
}