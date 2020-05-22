public static void main(String[] args) {
    // TODO code application logic here
    int UserIn = 0;
    double numberInputA;
    double numberInputB;
    double Answer;

    while (UserIn != 5) { //this starts while loop when user input is not equal to 5
        System.out.println("What type of calculation would you like to perform?");
        System.out.println("1. Add\n2. Subtract\n"
                + "3. Multiply\n4. Divide\n5. Exit");//shows the menu
        UserIn = getUserInput();
    }
}

private static int getUserInput() {
    int UserIn = 0;
    Scanner input = new Scanner(System.in);
    try {
        UserIn = input.nextInt();//ask user to input integer of choice
        if (UserIn > 5) {
            System.out.println("ERROR choose the numbers on the menu");
            return -1;
        } else if (UserIn < 1) {
            System.out.println("ERROR choose the numbers on the menu");
            return -1;
        }
        return UserIn;
    } catch (Exception ex) {
        System.out.println("ERROR only numbers are allowed");
        return -1;
    }
}