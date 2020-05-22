public static void main(String[] args) throws FileNotFoundException {
  while (true) {
     int userChoice = menu();

     switch (userChoice) {
     case 1: // only for animals
        int animal = animalSelect();
        String Name = null;
        switch (animal) {
        case 1:
           Name = "Animal - Lion";
           break;
        case 2:
           Name = "Animal - Tiger";
           break;
        case 3:
           Name = "Animal - Bear";
           break;
        case 4:
           Name = "Animal - Giraffe";
           break;
        default:
           System.out.println("ERROR: Invalid Selection");
           break;
        } 
        if (Name != null)  // read file only if selection is correct
           FileReader.readAnimal(Name);
        break;

     case 2: // only for habitat
        int habitat = habitatSelect();
        String habitatName = null;
        switch (habitat) {
        case 1:
           habitatName = "Habitat - Penguin";
           break;
        case 2:
           habitatName = "Habitat - Bird";
           break;
        case 3:
           habitatName = "Habitat - Aquarium";
           break;
        default:
           System.out.println("ERROR: Invalid Selection");
           break;
        } 
        if (habitatName != null) // read file only if selection is correct
           FileRead.readHabitat(habitatName);
        break;

     case 3 : // only for exit
        System.out.println("Thank you!");
        System.exit(0);

     default:
        System.out.println("ERROR: Invalid Selection");
     }

  }
}