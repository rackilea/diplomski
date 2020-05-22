public class AnimalShelter {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        //Save user input as temp variable values
        System.out.println("What is your animal's name?");
        String animalName = scan.nextLine();
        System.out.println("What is your animal's type?");
        String type = scan.nextLine();
        System.out.println("What is your animal's age?");
        int age = scan.nextInt();
         //Create an instance of your Animal class passing your temp variables
        Animal animal= new Animal(animalName,type,age);
        scan.nextLine();
        System.out.println("What is the name of your animal shelter?");
        String shelterName = scan.nextLine();

        //Create your Shelter class here passing the shelter name
        Shelter myShelter = new Shelter(shelterName);

        //Use the same class to pass your animal class(the one where you placed the attributes in) into the Shelter class.
        System.out.println(myShelter.toString(animal));

    }

}