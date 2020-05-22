public static hearts1() {  
    Scanner scanner = new Scanner(System.in);

    System.outprinln("Enter starting char:");

    String userInput = scanner.next();

    char heart = userInput.charAt(0);

    for (char currentChar = heart; currentChar < '❣'; currentChar++) {
        System.out.print(currentChar + " ");
    }

    scanner.close();
}