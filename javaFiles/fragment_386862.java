public class Animal {
    public void walk() {
        System.out.println("Walking");
    }
}


public class Dog extends Animal {
    public void bark() {
        System.out.println("Woof");
    }

    @Override
    public void walk() {
        System.out.println("Doggy walk");
    }

    public static void main(String[] args) {
        Dog dog = new Dog();
        Animal animal = new Animal();
        Animal animalDog = new Dog();
        dog.walk(); // "Doggy walk"
        dog.bark(); // "Woof"
        animal.walk(); // "Walking"
        animal.bark(); // Error: bark() is not defined in the Animal class
        animalDog.walk(); // "Doggy walk"
        animalDog.bark(); // Error: Animal class has no bark()
    }
}