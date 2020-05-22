public static void main(String[] args) throws IOException{
    int distance;
    int speed, time;
    String filename;

    System.out.println("Welcome to Distance Calculator.");

    // Create a scanner keyboard for user input
    Scanner keyboard = new Scanner(System.in);

    // Vehicle speed
    System.out.print("Vehicle speed (MPH): ");


    while (!keyboard.hasNextInt() || 
            ((speed = keyboard.nextInt()) < 1) ) {
        System.out.print("Please enter a valid #: ");
        keyboard.nextLine();
    }

    System.out.print("Time vehicle traveled (HR): ");

    while (!keyboard.hasNextInt() || 
            ((time = keyboard.nextInt()) < 1) ) {
        System.out.print("Please enter a valid #: ");
        keyboard.nextLine();
    }

    keyboard.nextLine(); // Consume next line

    // Get filename
    System.out.print("File name for saving: ");
    filename = keyboard.nextLine();

    // Open file
    String filePath = "C:/Users/Nik/Desktop/";
    PrintWriter outputFile = new PrintWriter(filePath + filename);

    outputFile.println("Hour        Distance Traveled");
    outputFile.println("-----------------------------");

    for (int hour = 1; hour <= time; hour++) {
        distance = (speed * hour);
        outputFile.println(hour + "\t\t\t" + (distance + " Mi"));
    }
    outputFile.close();
    System.out.print("Date written to " + filePath + filename);
}