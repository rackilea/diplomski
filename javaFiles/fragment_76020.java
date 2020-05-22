public abstract class Animal {
   public abstract void speak();
}

public class Dog extends Animal {
   @Override
   public void speak() {
       System.out.println("Woof!");
   }
}

public class Cat extends Animal {
   @Override
   public void speak() {
       System.out.println("Meow!");
   }
}