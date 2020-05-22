System.out.println("Enter the number of pets to store information for:");
int amount = Integer.parseInt(keyboard.nextLine());
outputStream.println("Patient Data:");
outputStream.println("Pet Name Pet Type Number of Visits");

String petName = new String();
String petType = new String();
int numVisit = 0;

for (int index = 0; index < amount; index++) {
    System.out.println("Type the pet name, then press Enter:");
    petName = keyboard.nextLine();
    System.out.println("Type the animal type (dog, cat, bird, rodent), then press Enter:");
    petType = keyboard.nextLine();
    System.out.println("Type the number of visits last year, then press Enter:");
    numVisit = Integer.parseInt(keyboard.nextLine());
    outputStream.printf("%8s %-8s %-8d%n", petName, petType, numVisit);
}