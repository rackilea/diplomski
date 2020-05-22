import java.util.InputMismatchException;
import java.util.Scanner;

public class Bank {
    public static void main(String[] args) {
        double balance = 0;
        double amount = 0;

        @SuppressWarnings("resource")
        Scanner in = new Scanner(System.in);

        int userChoice;
        BankAccount account1 = new BankAccount();
        boolean quit = false;
        {
            do {
                System.out.println("Your Choice: ");
                System.out.println("For Deposit type 1");
                System.out.println("For Withdraw type 2");
                System.out.println("For Check Balance type 3");
                System.out.println("Type 0 to quit");

                System.out.print("User Input :");
                userChoice = in.nextInt();

                switch (userChoice) {
                    case 1:

                    // Deposit Money
                    boolean inputInvalid = false;

                    do {
                        System.out.println("How Much would you like to deposit?");
                        try {
                            // in.useDelimiter("\n");
                            amount = in.nextDouble();
                            inputInvalid = false;
                        } catch (InputMismatchException ime) {
                            System.out.println("Invalid input. Try Again");
                            inputInvalid = true;
                        }
                    } while (inputInvalid);

                   System.out.println("Depositing: " + amount);
                   account1.deposit(amount);
                   // balance = amount + balance;
                    break;

                  case 2:
                  // Withdraw money
                      boolean InvalidInput = false;
                      do {
                          System.out.println("How Much would you like to withdraw?");
                          try {
                              // in.useDelimiter("\n");
                              amount = in.nextDouble();
                              InvalidInput = false;
                          } catch (InputMismatchException ime) {
                              System.out.println("Invalid input. Try Again");
                              InvalidInput = true;
                          }
                      } while (InvalidInput);

                      System.out.println("Withdrawing: " + amount);
                      account1.withdraw(amount);
                      // balance = balance - amount;
                      break;
                   case 3:
            // check balance
            System.out.println("Checking Balance.");
            account1.getBalance();
            System.out.println("Available Balance is : " + account1.getBalance());
            break;
       case 0:
            System.out.println("Thanks for Using BankAccount Banking System!");
            quit = true;
            break;
        default:
            System.out.println("Error: Choice not recognized please choose again.");
        continue;
    }
    if (userChoice == 0)
        quit = true;
  } while (!quit);
 }
}
}