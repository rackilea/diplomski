public class Main {

    public static void main(String[] args) {

    Demo.main(args); // populate the ArrayList in Demo Class main method 2.
    ArrayList<Animal> animalGroup = Demo.animalGroup; // Retrieve the ArrayList in Demo class.
    for(Animal animal : animalGroup) {
         System.out.println(animal.getName()+","+animal.getAge());
    }
}
}