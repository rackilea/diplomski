package test;

public class Main {

    public static void main(String[] args) {
        /*
         * Abstract class - using anonymous idiom here
         * Can invoke:
         * move
         * forAnimalAndChildren
         * all Object methods
         */
        Animal animal = new Animal(){}; 
        /*
         * Instance type is Dog but reference is Animal
         * Can invoke:
         * move
         * forAnimalAndChildren
         * all Object methods
         * Note that invoking "move" will 
         * resolve to Dog's "move" implementation at runtime, 
         * if any is provided in class Dog
         */
        Animal dogReferencedAsAnimal = new Dog();
        /*
         * Instance and reference types are Dog
         * Can invoke:
         * move
         * forAnimalAndChildren
         * onlyDog
         * all Object methods
         */
        Dog dog = new Dog();

    }
    /*
     * Setting this up as an abstract class, as no concrete "animals" can exist - only more specific types. 
     */
    static abstract class Animal {
        void move() {
            System.out.println("Animal moving...");
        }
        void forAnimalAndChildren() {
            System.out.println("Anyone extending Animal can invoke me!");
        }
    }
    static class Dog extends Animal {
        @Override
        void move() {
            System.out.println("Dog moving...");
        }
        void onlyDog() {
            System.out.println("Only for dogs!");
        }
    }
}