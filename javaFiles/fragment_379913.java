do {

    try {
        guess = sean.nextInt();

        if (guess >= 1 && guess <= 6) break;

    } catch (InputMismatchException e) {
    } finally {
        sean.nextLine();
    }

    System.out.print("Input must be a number between 1 and 6: ");
} while (true);