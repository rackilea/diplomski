class Person {
    String name;
    boolean alive;

    Person(String _name) {
        name = _name;
        alive = true;
    }

    void kill(Person anotherPerson) {
        anotherPerson.die();
    }

    void createAndKill() {
        Person newPerson = new Person("John Doe");
        newPerson.kill();
    }

    void die() {
        alive = false;
    }
}