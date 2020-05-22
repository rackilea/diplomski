private static int getAnswer() {
        Scanner scanner = new Scanner(System.in);
        try {
        System.out.println("Please input a number");
        int num1 = scanner.nextInt();
        System.out.println("Please input a second number");
        int num2 = scanner.nextInt();
       return num1+ num2;
         } catch (InputMismatchException exp) {
           System.out.println("Exception thrown, please reenter values:");
           getAnswer();
        }
       return 0;
 }