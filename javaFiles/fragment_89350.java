public abstract class AnimalStore<T extends Animal> {
    //Some members
    private List<T> animals;

    public abstract void addAnimal(T a);

    //Methods forwarding some List methods
    //remove, find, count, 

    public T get(final int n) {
        return animals.get(n);
    }
}

//Method for returning a copy of the list.

public class DogStore extends AnimalStore<Dog> {
    //some memebers
    @Override
    public void addAnimal(final Dog a) {
        //Assert is a dog because this is a Dogs Store
    }
}

public abstract class Animal {
    //Some members
}

public class Dog extends Animal {
    //Some members
}