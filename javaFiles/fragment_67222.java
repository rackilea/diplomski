public static double[] getUserInput() {

    Scanner sc = new Scanner(System.in);

    List<Double> inputList = new ArrayList<Double>();

    System.out.println("Please enter how many numbers you will be inputing");
    int numberOfInputs = sc.nextInt();

    for (int i = 0; i < numberOfInputs; i++) {
        System.out.println("Please enter a number");
        double userInput = sc.nextDouble(); // Store user inputed double into temporary variable
        inputList.add(userInput); // Add temporary variable into ArrayList
    }
    sc.close();

    double[] arr = new double[inputList.size()];
    for (int i = 0; i < arr.length; i++) {
        arr[i] = inputList.get(i);
    }
    return arr;
}