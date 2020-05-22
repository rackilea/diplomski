Scanner keyboard = new Scanner(System.in);

int smallest = Integer.MAX_VALUE;
String input = "";

System.out.println("This program find the smallest number" 
    + " in a series of numbers");
System.out.println("When you want to exit, type Q");

while (!input.toLowerCase().equals("q")) {
    System.out.print("Enter a number: ");
    input = keyboard.next();
    try {
        int numb = Integer.parseInt(input);
        if (numb < smallest) 
            smallest = numb;
    } catch (NumberFormatException e) {
        // Maybe check for other random strings here?
        // If you expect only "Q" or a number, then no need
    }
}

System.out.println("Smallest number: " + smallest);
System.exit(0);