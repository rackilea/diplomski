do{
    System.out.println("W. Withdraw");
    System.out.println("D. Deposit");
    System.out.println("B. View Balance");
    System.out.println("To exit program, type Quit");
    Scanner keyboardMenu = new Scanner(System.in);
    menuOptions = keyboardMenu.next();
    boolean keepGoing = true; 
   //Switch statement to navigate menu options
   switch (menuOptions) {
case "B": 
       System.out.println("Your balance is $" + balance);
       break;
case "D":
       System.out.println("Deposit: ");
       Scanner keyboardDeposit = new Scanner(System.in);
    double deposit = keyboardDeposit.nextDouble();
    balance = balance + deposit;
    System.out.println("Your new balance is $" + balance);
    break;
case "W":
    System.out.println("Withdraw: ");
    Scanner keyboardWithdraw = new Scanner(System.in);
    double withdraw = keyboardWithdraw.nextDouble();
    balance = balance - withdraw;
    System.out.println("Your new balance is $" + balance);
    break;
case "Quit":
    System.out.println("Program terminated.");
    keepGoing = false; 
    break;
default:
    System.out.println("Please select an option.");
    break;
}while(keepGoing)