String assignment;
    String exit=null;
    double earned, total;
    int i = 0;
    Scanner scan = new Scanner(System.in);

    while (!"Y".equalsIgnoreCase(exit)) {
        i++;
        System.out.print("Please enter name of assignment " + i + ": ");
        assignment = scan.nextLine().toUpperCase(); //consumes string + \n
        System.out.print("Please enter points earned: ");
        earned = scan.nextDouble();//consumes double
        scan.nextLine();//consumes \n
        System.out.print("Please enter total points possible: ");
        total = scan.nextDouble();
        scan.nextLine();

        System.out.print("Assignment\t");
        System.out.print("Score\t");
        System.out.print("Total       Points\t");

        System.out.print(assignment + "\t\t");
        System.out.print(earned + "\t");
        System.out.println(total + "\t\t");

        System.out.print("Stop?(Y/N)");
        exit = scan.nextLine();
    }