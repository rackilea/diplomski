import java.util.Scanner;

class Main
{
    static Scanner kbd = new Scanner(System.in);
    static Account[] accounts = new Account[100];

    static class Account
    {
        //public int money;
        public String accountNumber;

        public Account()
        {
            //System.out.println("\nHow much money do you want to put in?");
            //money = Kbd.nextInt();
            System.out.println("\nWhat account number do you want?");
            accountNumber = kbd.next();
        }
    }

    public static void main(String[] args)
    {
        int oMenu = 1;
        int pos = 0;
        while (oMenu == 1 || oMenu == 2)
        {
            System.out.println("\nClick 1 to make an account\nClick 2 to login\nClick 3 to exit the program");
            oMenu = kbd.nextInt();
            if (oMenu == 1)
            {
                for (int i = 0; i<accounts.length; i++)
                {
                    if (accounts[i] == null)
                    {
                        accounts[i] = new Account();
                        break;
                    }
                }
            }

            if (oMenu == 2)
            {
                System.out.println("Input your accountnumber: ");
                String s = kbd.next();
                Account found=null;
                for (int i = 0; i<accounts.length; i++)
                {
                    if (accounts[i] != null && s.equals(accounts[i].accountNumber))
                    {
                        found=accounts[i];
                    }
                }
                if (found!=null)
                {
                    System.out.println("Welcome! nr. "+found.accountNumber);
                }
                else
                {
                    System.out.println("There are no accounts with that given accountnumber!");
                }
            }
        }
    }
}