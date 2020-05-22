class Person {
    String name;
    Person(String n) { name = n; }
    public String toString() { return name; }
}

class GoodPerson extends Person {
    GoodPerson(String n) {
        super(n);
    }
}

class BadPerson extends Person {
    BadPerson(String n) {
        super(n);
    }
}