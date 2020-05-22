Scanner input = new Scanner(System.in);
System.out.println("Enter a number between 1 and 3999 (-1 to quit):");

while (!input.hasNext("-1")) {

    String a = input.next(); // gets the next item from the Scanner

    try {
        Integer number = Integer.parseInt(a); // tries to 'cast' the String to an Integer

        if ((number <= 3999) && (number > 0)) {
            System.out.println(arabicToRoman(number)); // prints out the result

        } else if (number > 3999) {
            System.out.println("Error: number must be between 1 and 3999");

        } else if (number == 0) {
            System.out.println("Error: The Romans did not have a way to represent negative numbers or zero.");

        } else {
            System.out.println("Error: The Romans did not have a way to represent negative numbers or zero.");

        }
    } catch (NumberFormatException e) {
        System.out.println("You did not enter a number!");
    }
}