public static int getInt() {

    Scanner sc = new Scanner(System.in);

    boolean bool = true;
    int answerInt = 0;

    System.out.println("Enter an int");

    while (bool) {
        try {
            answerInt = sc.nextInt();
            bool = false;
            sc.close(); 
        } catch (InputMismatchException e) {
            System.out.println("Try again");
            sc.next(); //Can you figure out why this line is needed?
        }

    }

    return answerInt;

}