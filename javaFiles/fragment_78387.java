boolean wasError = false;
int choice;
do {
    try {
        // ...
    } catch (InputMismatchException inputMismatchException) {
        // ...
        wasError = true; // Set the guard
    }

    // Check the guard
    if (wasError) {
        // Something went wrong, abort the loop
        break;
    }
} while (choice < 1 || choice > 2);