abstract class Animal<T extends Animal<T>> {
    abstract void sonOf(T son);
}

final class Dog extends Animal<Dog> {
    void sonOf(Dog dog) { ... }
}

final class Cat extends Animal<Cat> {
    void sonOf(Cat cat) { ... }
}