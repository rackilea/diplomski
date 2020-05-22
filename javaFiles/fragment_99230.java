public static void main(String args[]){
    boolean done = false;
    int oper;
    Scanner input = new Scanner(System.in);
    System.out.println("McMackins Calc v2.0 (Now with fewer crashes!)");

    while (!done) {
        System.out.println("What operation? (0 for quit, 1 for add, 2 for subtract, 3 for multiply, 4 for divide, 5 for divide with remainder, 6 for average, 7 for account interest):");
        while (!input.hasNextInt()){
            System.out.println("Enter a valid integer.");
            input.next();
        }
        oper = input.nextInt();
        switch (oper){
        case 0:
            done = true;
            break;
        case 1:
            System.out.println("1");
            break;
        case 2:
            System.out.println("2");
            break;
        case 3:
            System.out.println("3");
            break;
        case 4:
            System.out.println("4");
            break;
        case 5:
            System.out.println("5");
            break;
        case 6:
            System.out.println("6");
            break;
        case 7:
            System.out.println("7");
            break;
        default:
            System.out.println("Invalid entry.");
            break;
        }
    }
    input.close();
}