public class AnimalFactory {
    public Animal createAnimal(String type) {
        if ("canine".equals(type)) {
            return createDog();
        } else {
            return createCat();
        }
    }

    Dog createDog() { return new Dog(); }

    Cat createCat() { return new Cat(); }
}