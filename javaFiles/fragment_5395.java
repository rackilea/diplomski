public abstract class Animal {
    private final String sound;

    protected Animal(String sound) {
        this.sound = sound;
    }

    public String speak(){
        return sound;
    }
}

public class Cat extends Animal {
    public Cat() {
        super("meow");
    }
}

public class Dog extends Animal {
    public Dog() {
        super("woof");
    }
}