public static void main(String args[]) 
{
    Scanner scan = new Scanner(System.in);
    System.out.println("Do you choose rock, paper or scissors?");
    String userChoice = scan.nextLine();
    String computerDec = computersTurn(); // assign it here
    compare(userChoice, computerDec);
}