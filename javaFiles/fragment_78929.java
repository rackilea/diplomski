public interface Animal {

    public void speak();
}

public class Dog implements Animal {

    @Override
    public void speak() {       
        System.out.println("Woof!");        
    }

}
public class Cat implements Animal {

    @Override
    public void speak() {
        System.out.println("Meow!");
    }

}

public abstract class AnimalFactory {

    public static final int CAT = 0;
    public static final int DOG = 1;

    public static Animal createAnimal(int type){

        switch(type){
            case CAT:
                return new Cat();
            case DOG:
                return new Dog();
        }           
        return null;
    }
}


public class App {
    public static void main(String[] args) {

        Animal animal = AnimalFactory.createAnimal(AnimalFactory.CAT);      
        animal.speak();

    }   
}