interface AnimalFactory<T extends Animal>
{
    T create();
}

interface CountingAnimalFactory<T extends Animal> extends AnimalFactory<T>
{
    int numberOfAnimals();
}

public class CountingDogFactory implements CountingAnimalFactory<Dog>
{
    private int numberOfDogs;

    public Dog create() {
        numberOfDogs++;
        return new Dog();
    }

    public int numberOfAnimals() {
         return numberOfDogs;
    }
}