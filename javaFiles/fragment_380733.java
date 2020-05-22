import java.util.ArrayList;
public class Demo {
    public static ArrayList<Animal> animalGroup; // make this an instance static variable to access in other class with main method;

    public static void main(String[] args) {
    animalGroup = new ArrayList<>();

    animalGroup.add(new Wolf("Sam", 5));
    animalGroup.add(new Parrot("George", 3));
    animalGroup.add(new Wolf("Wesley", 7));
    animalGroup.add(new Parrot("Pat", 10));

    }

}