import java.util.ArrayList;
import java.util.List;

abstract interface Pet {
    public String Talk();
}

class Dog implements Pet {

    public String Talk() {
        return "Woof!";
    }
}

public class Person {
    List<Pet> pets = new ArrayList<Pet>();

    public Person() {
        pets.add(new Dog());
    }

    public void MakePetsSpeak() {
        for (int i = 0; i < pets.size(); i++) {
            System.out.println(pets.get(i).Talk());
        }
    }

    public static void main(String[] args) {
        Person p = new Person();
        p.MakePetsSpeak();
    }
}