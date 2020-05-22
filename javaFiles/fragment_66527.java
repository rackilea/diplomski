public static void main(String[] args){
    char whatnow = 'Y';
    Scanner scan = new Scanner(System.in);

    while (whatnow != 'N' && whatnow != 'n') {
        int choice = printMenuAndAsk(scan);

        if (choice == 99)
            break;
        else performOperation(choice, scan);

        System.out.println("Do you want to continue calculating? [Y/N]:"); 
        whatnow = scan.next().charAt(0);

        while(whatnow != 'N' && whatnow != 'Y' && whatnow != 'n' && whatnow != 'y') { 
            System.out.println("Incorrect answer");
            whatnow = scan.next().charAt(0);
        }
    }   
    scan.close();   
}

public static int printMenuAndAsk(Scanner scan) {
    int choice;

    System.out.println("Welcome to StemCalc Z Edition(Integers only)!");
    ...
    System.out.println("Enter your choice[1-4 or 99]:"); 
    choice = scan.nextInt();

    while ((choice < 1 || choice > 4) && choice != 99) {
        System.out.println("Please enter 1, 2, 3, 4, or 99: ");
        choice = scan.nextInt();
    }

    return choice;
}

public static void performOperation(int operation, Scanner scan) {
    System.out.println("Enter first:");
    int firstnumber = scan.nextInt();
    System.out.println("Enter second:");
    int secondnumber = scan.nextInt();

    if (choice == 1)
        System.out.println(firstnumber + " + " + secondnumber + " = " + (firstnumber+secondnumber));
    else if (choice == 2) 
        System.out.println(firstnumber + " - " + secondnumber + " = " + (firstnumber-secondnumber));
    else if (choice == 3) 
        System.out.println(firstnumber + " * " + secondnumber + " = " + (firstnumber*secondnumber));
    else if (choice == 4) {
        while (secondnumber == 0) {
            System.out.println("ERROR-CANNOT DIVIDE TO ZERO! Type another integer:");
            secondnumber = scan.nextInt();
        }
        System.out.println(firstnumber + " / " + secondnumber + " = " + (firstnumber/secondnumber));
    }
}