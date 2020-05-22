// While the next input is not a double value, repeat
while (!keyboard.hasNextDouble()) {
    System.out.println("Please enter a valid numeric value");
    keyboard.nextLine();  // Move Scanner past the current line
}

double distance = keyboard.nextDouble();