int choice; // Declaration without initialization
do {
    try {
        // ...
        choice = console.nextInt(); // Exception could be thrown
    } catch (InputMismatchException inputMismatchException) {
        // ...
        // Code then continues here, without choice being initialized
    }
} while (choice < 1 || choice > 2); // Access of unassigned variable