abstract class Base<T extends Base<?>> {

    private final T parent;

    Base() {
        this.parent = null;
    }

    Base(T parent) {
        this.parent = parent;
    }

    public T done() throws NullPointerException {
        if (parent != null) {
            return parent;
        }

        throw new NullPointerException();
    }
}

class Farm<T extends Base<?>> extends Base<T> {

    private final Animal<Farm<T>> animal;
    private final Human<Farm<T>> human;

    public Farm() {
        super();
        this.animal = new Animal<>(this);
        this.human = new Human<>(this);
    }

    public Animal<Farm<T>> animal() {
        return this.animal;
    }

    public Human<Farm<T>> human() {
        return this.human;
    }
}

class Animal<T extends Base<?>> extends Base<T> {

    private Cat<Animal<T>> cat;
    private Dog<Animal<T>> dog;

    public Animal() {
        super();
        init();
    }

    public Animal(T parent) {
        super(parent);
        init();
    }

    private void init() {
        this.cat = new Cat<>(this);
        this.dog = new Dog<>(this);
    }

    public Cat<Animal<T>> cat() {
        return cat;
    }

    public Dog<Animal<T>> dog() {
        return dog;
    }
}

class Human<T extends Base<?>> extends Base<T> {
    public Human() {
        super();
    }

    public Human(T parent) {
        super(parent);
    }

    public Human<T> saysHello() {
        System.out.println("human says hi");
        return this;
    }
}

class Cat<T extends Base<?>> extends Base<T> {

    private Human<Cat<T>> human;

    public Cat() {
        super();
        init();
    }

    public Cat(T parent) {
        super(parent);
        init();
    }

    private void init() {
        this.human = new Human<>(this);
    }

    public Cat<T> meow() {
        System.out.println("cat says meow");
        return this;
    }

    public Human<Cat<T>> findsHuman() {
        return this.human;
    }
}

class Dog<T extends Base<?>> extends Base<T> {

    private Human<Dog<T>> human;

    public Dog() {
        super();
        init();
    }

    public Dog(T parent) {
        super(parent);
        init();
    }

    private void init() {
        this.human = new Human<>(this);
    }

    public Dog<T> bark() {
        System.out.println("dog says woof");
        return this;
    }

    public Dog<T> chacesCar() {
        System.out.println("cat drinks milk");
        return this;
    }

    public Human<Dog<T>> findsHuman() {
        return this.human;
    }

}