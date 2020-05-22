public static void main(String[] args) {

    while (true) {
        double[] userInput = getValues();
        double radicalValue = calcDisc(userInput);

        System.out.println(radicalValue);
    }
}