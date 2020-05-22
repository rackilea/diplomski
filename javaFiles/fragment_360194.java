public static void main(String[] args) {

    printBanner();
    while (true) {
        double[] userInput = getValues();
        double radicalValue = calcDisc(userInput);

        System.out.println(radicalValue);
    }
}

private static void printBanner() {
    System.out.println("Fourth Assignment by MyNameHere");
    System.out.println("Welcome to the quadratic formula computation tool.");
    System.out.println("This tool will solve problems in the form of: a^x + bx + c.");
}