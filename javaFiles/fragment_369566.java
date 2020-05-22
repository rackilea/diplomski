System.out.println("What menu would you like to access? 0. Add Students 1. Change Mark 2. List Marks and Students");
int choice = keyboard.nextInt();

if (choice == 0) {
    // run code for Add Students
} else if (choice == 1) {
    // code for change mark
} else if (choice == 2) {
    // list marks code
} else {
    System.out.println("Invalid input");
    //  handle invalid input somehow if you want
}