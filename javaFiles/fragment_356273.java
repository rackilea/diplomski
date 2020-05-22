public static int getNumberFromUser(Scanner scan)
{
    boolean userEnteredNumber = false;
    while(!userEnteredNumber)
    {
        System.out.println("Please enter a number: ");
        String inputFromUser = scan.nextLine();
        if(inputFromUser.matches("\\d+"))
        {
            return Integer.parseInt(inputFromUser);
        }
        else
            System.out.println("Input Not an Integer - " + inputFromUser);
    }
    return 0;
}