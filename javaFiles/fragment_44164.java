public Person clone() {
    try {
        return (Person) clone();
    } catch (CloneNotSupportedException e) {
        throw new RuntimeException("This should be impossible ...");
    }
}