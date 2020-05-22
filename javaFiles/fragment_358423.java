class Animal {

    void printName() {
        System.out.println("Animal");
    }
}
class Dog extends Animal{

    @Override
    void printName() {
        System.out.println("Dog");
    }
}
class Cat extends Animal{

    @Override
    void printName() {
        System.out.println("Cat");
    }

    void meow() {
        System.out.println("meow");
    }
}