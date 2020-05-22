public class Person {
    String name;
    Animal pet;
    // Getters & Setters + Constructor
}

public abstract class Animal {
    private String name;

    public Animal(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

public class Cat extends Animal {
    public Cat() { super("Cat")); }
}

public class Elephant extends Animal {
    public Elephant() { super("Elephant")); }
}

public class Lion extends Animal {
    public Lion() { super("Lion")); }
}