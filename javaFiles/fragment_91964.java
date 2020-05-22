public static boolean doAgain() {
    Scanner kb = new Scanner(System.in);
    String answer = "";
    do {
        System.out.println("Do you want to do this again? Enter yes to continue or no to quit");
        answer = kb.nextLine();
    } while (incorrect(answer)); // Better not use double negative

    if (answer.equals("yes"))
        return true;
    else
       return false;
}

public static boolean incorrect(String answer) {
    if (answer.equals("yes") || answer.equals("no"))
        return false; // answer is correct
    else
        return true; // answer is incorrect
}