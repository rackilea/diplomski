public static double attemptInputElement(Scanner stdin) {
    try { 
      double j = stdin.nextDouble();
    } catch (InputMismatchException ex) {
      System.out.print("Invalid input, please enter a valid element");
      stdin.nextLine(); // skip the last input
      attemptInputElement(stdin);
    }
    return 0.0; // should never get reached.
  }

  public static double[] getArrayInput() {
    Scanner stdin = new Scanner(System.in);
    int arrayLength;
    double[] arrayInput = null;
    System.out.print("Please enter the length of the array: ");
    try { 
      arrayLength = stdin.nextInt();
      while (arrayLength <= 0) {
        System.out.print("Invalid input, please enter a positive integer: ");
        arrayLength = stdin.nextInt();
      }
    } catch (InputMismatchException ex) {
      System.out.print("Invalid input, please enter a positive integer: ");
      stdin.nextLine(); // skip the last input
      arrayLength = stdin.nextInt();
    }
    arrayInput = new double[arrayLength];
    System.out.print("Please enter the array elements: ");
    for (int i = 0; i < arrayLength; i++) {
      do {
          arrayInput[i] = attemptInputElement(stdin);
      } while (arrayInput.length < arrayLength);
    }
    return arrayInput;
  }