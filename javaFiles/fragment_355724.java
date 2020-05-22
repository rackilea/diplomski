class Person {
    String name;
    Person parent;

    Person(String name, Person parent) {
        this.name = name;
        this.parent = parent;
    }

    // etc (getters, setters)
}

public class MainApp {
    public static void main(String[] cmdArgs) {
        Person george = new Person("George", null);
        Person nick = new Person("Nick", null);
        Person a = new Person("a", george);
        Person b = new Person("b", george);
        Person c = new Person("c", nick);
        // etc.
    }
}