public class Dog implements IAnimal {

    private String name;

    public Dog(Dog dog) {
        this.name = dog.name;
    }
}