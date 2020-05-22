System.out.println("Enter the number of pets to store information for:");
int amount = Integer.parseInt(keyboard.nextLine());
String [] petNames = new String [amount];
String [] petTypes = new String [amount];
int [] numVisits = new int [amount];
outputStream.println("Patient Data:");
outputStream.println("Pet Name Pet Type Number of Visits");

for (int index=0;index < amount; index++) {
    System.out.println("Type the pet name, then press Enter:");
    petNames[index] = keyboard.nextLine();
    System.out.println("Type the animal type (dog, cat, bird, rodent), then press Enter:");
    petTypes[index] = keyboard.nextLine();
    System.out.println("Type the number of visits last year, then press Enter:");
    numVisits[index] = Integer.parseInt(keyboard.nextLine());
    outputStream.printf("%8s %-8s %-8d%n", petNames[index], petTypes[index], numVisits[index]);
}