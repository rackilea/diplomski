public class MyBank {

public static void main(String[] args) {

    Account[] bank = { new Account(), new Account(), new Account(),
            new Account() };

    bank[0].setBalance();
    bank[1].setBalance();
    bank[2].setBalance();
    bank[3].setBalance();

    double x = 100.00;
    System.out.printf("Transferring $%.2f from Acc 1 to Acc 2.\n", x); //printf example
    System.out.println("Acc 1 previous balance: " + bank[0].getBalance());
    System.out.println("Acc 2 previous balance: " + bank[1].getBalance());
    bank[0].transferTo(bank[1], x);


    System.out.println("Acc 1 new balance: " + bank[0].getBalance());
    System.out.println("Acc 2 new balance: " + bank[1].getBalance());


}
}