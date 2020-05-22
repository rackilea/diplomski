public static double[] getValues() {
    double[] userInput;
    userInput = new double[3];
    try (Scanner kbd = new Scanner(System.in)) {
        System.out.println("Please enter the values you would like for a, b, and c.");
        for (int i = 0; i < userInput.length; i++) {
            userInput[i] = kbd.nextDouble();
        }
    }
    return userInput;
}