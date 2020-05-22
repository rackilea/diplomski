abstract class Animal {
    abstract void makeSound();
}

class Dog extends Animal {
    void makeSound() { System.out.println("Bark"); }
}

class Cat extends Animal {
    void makeSound() { System.out.println("Meow"); }
}