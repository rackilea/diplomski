public static Integer getValue (Scanner input, int minValue, int maxValue) {
    int value;
    value = 0;
    while (true) {
        try {
            value = input.nextInt();
            if((value < minValue) || (value > maxValue)) {
                // ERROR message goes here
            } else {
                break; // Input successful, break loop.
            }
        } catch (InputMismatchException IME) {
            // ERROR message goes here.
            input.nextLine(); // Discards input so user can try again
        }
    }
    return (value);
}