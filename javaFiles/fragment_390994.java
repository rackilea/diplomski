class Person {
    private final int id;

    Person() {
        id = generateId();
    }

    protected int generateId() {
        return IdGenerator.gen();
    }
}