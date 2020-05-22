public abstract class Animal
{
    private final String name;

    public Animal(String name)
    {
        this.name = name;
    }

    public void printName()
    {
        System.out.println(name);
    }

    // more animal general stuff followed by:

    public abstract void makeSound();

}

public class Dog extends Animal
{
    public Dog()
    {
        super("Dog");
    }

    @Override
    public void makeSound()
    {
        System.out.println("Woof!");
    }
}

List<Animal> aList = new ArrayList<Animal>();
aList.add(new Dog());
aList.add(new Cat());
// etc
for (Animal a : aList) 
{
    a.printName();
    a.makeSound(); // calls each subclasses' "makeSound()"
}