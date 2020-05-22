public static void main(String[] args) {
    Scanner sc = new Scanner(System.in).useDelimiter("\\R");
    System.out.print("Enter first numeric value: ");
    double d1 = getDouble(sc);
    System.out.print("Enter second numeric value: ");
    double d2 = getDouble(sc);
    System.out.print("Choose an operation (+ - * /): ");
    while(!sc.hasNext("[-+*/]")) {
      System.out.println(sc.next()+" is not a valid operation");
    }
    String operation = sc.next();

    double result;
    switch (operation) {
        case "+": result = d1 + d2; break;
        case "-": result = d1 - d2; break;
        case "*": result = d1 * d2; break; 
        case "/": result = d1 / d2; break;
        default:
            throw new AssertionError("should not happen due to pretest");
    }
    System.out.println(d1+operation+d2);
    System.out.println("The answer is " + result);
}    
private static double getDouble(Scanner sc) {
    while(!sc.hasNextDouble()) {
        System.out.println(sc.next()+" is not a number");
    }
    return sc.nextDouble();
}