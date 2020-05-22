public class Example
{
  public static void main(String[] args)
  {
    Animal animal = new Animal();
    System.out.println(animal.name);
    animal.makeSound();
    Animal doggy = new Dog();
    System.out.println(doggy.name);
    doggy.makeSound();
  }
}

public class Animal {
  public String name;

  public Animal() {
    name = "NameLess";
  }

  public void makeSound() {
    System.out.println("What am I?");
  }
}

public class Dog extends Animal {

  public Dog() {
    name = "Goofy";
  }

  public void makeSound() {
    System.out.println("woof woof!");
  }
}