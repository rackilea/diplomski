public static String askToContinue(Scanner sc) {
    String choice = "";
    boolean isValid = false;
    while (!isValid) {
        System.out.print("Continue? (y/n): ");
        choice = sc.nextLine(); //to reads all line , because this cannot read with empty enter input
        isValid = true;
        if (choice.isEmpty()) {  //this isEmpty for empty enter
            System.out.println("Error! "
                    + "This entry is required. Try again");
        }
        System.out.println(choice);
        //this logic if not y or n , it will return error
        if (!choice.equals("y") && !choice.equals("n")) {
            System.out.println("Error! Entry must be 'y' or 'n'. Try again");
            isValid = false;
        }
    }
    //sc.nextLine();  // discard any other data entered on the line
    System.out.println();
    return choice;
}