public class MainApp {
    public static void main(String args[]){
        Bank bank = new Bank(3);// a bank that will hold up to 3 accounts
        BankAccount acc1 = new BankAccount("Stacey", 7500);
        BankAccount acc2 = new BankAccount("Maria", 15000);
        bank.add(acc1);
        bank.add(acc2);
        bank.isFull();
    }
}