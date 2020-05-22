// Bank class


 public class BankMain {

    public static void main(String[] args) 
    {

        Account account1 = new Account(1000,"11223A");
        Account account2 = new Account(10000,"11111A");
        Client client = new Client("George");

        client.addAccount(account1);
        client.addAccount(account2);

        client.printAccountDetails();
    }

}