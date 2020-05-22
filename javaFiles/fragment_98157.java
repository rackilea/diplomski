abstract class Animal 
{ 
    public void saySomething()
    {
        System.out.println("Some Animal sound");
    }

    public abstract void getTheBall();
}

class Horse extends Animal
{ 
    public void saySomething()
    {
        System.out.println("Neigh Neigh");
    }

    public void getTheBall()
    {
        System.out.println("I won't, Try a dog, I am a Horse!");
    }
}

class Dog extends Animal 
{ 
    public void saySomething()
    {
        System.out.println("woof woof, waon waon");
    }

    public void getTheBall()
    {
        System.out.println("huf huf, here it is!");
    }
}

public class Main 
{
    public static void main (String [] args) 
    {
        Dog dog = new Dog(); 
        Horse horse = new Horse();
        Animal animal = dog;
        Animal horseAnimal = new Horse();

        //upcasting
        Dog upcastedAnimal = upcastToDog(animal);
        dog.saySomething();
        dog.getTheBall();

        upcastedAnimal.saySomething();
        upcastedAnimal.getTheBall();

        horse.saySomething();
        horse.getTheBall();

        try {
            Dog upcastedDog = upcastToDog(horseAnimal);
        } catch (Exception ex){
            System.out.println(ex.getClass().getSimpleName() + ": Obviously a horse is not a dog!");
        }
    }

    public static Dog upcastToDog(Animal animal){
        return (Dog) animal;
    }
}