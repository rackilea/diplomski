System.out.print("Enter your name... ");

String line = sc.nextLine();

while (line.length() > 50) {
    System.out.println("Error: you entered more than 50 characters");

    // Ask the user for their name again...
    System.out.print("Enter your name... ");
    line = sc.nextLine();
}

System.out.println("Your name is " + line);