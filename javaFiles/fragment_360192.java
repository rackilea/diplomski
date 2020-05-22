public static void main(String[] args) {

    double[] userInput = getValues();
    double radicalValue = calcDisc(userInput);

    System.out.println(radicalValue);
}

// ...

    public static double calcDisc(double[] userInput) {
    double aValue = userInput[0];
    double bValue = userInput[1];
    double cValue = userInput[2];
    double radicalValue = (Math.pow(bValue, 2) - (4 * aValue * cValue));
    return radicalValue;
}