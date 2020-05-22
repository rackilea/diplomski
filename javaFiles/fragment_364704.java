public void getInfo(String nameIn) {
    Scanner keyboard = new Scanner(System.in);
    Scanner x;
    System.out.println("\nWhat's your account's name?");
    nameIn = keyboard.nextLine();

//It reads the title of the file, not the data inside it.
try {
    File file = new File("nameOfYourFile.txt");
    x = new Scanner(file);
    while (x.hasNextLine())) {
        String line = x.nextLine();

        if (line.contains(nameIn)){  // or you can use startsWith() 
                                    // depending how your text is formatted
            String[] tokens = line.split(" ");
            String a = tokens[0].trim();
            String b = tokens[1].trim();
            String c = tokens[2].trim();
            System.out.println("Account data for user: " + nameIn);
            System.out.printf("Name: %s \tAge: %s \tExperience: %s", a, b, c);

        }
    }
} catch (FileNotFoundException e) {
    System.out.println("Could not find file.");
}