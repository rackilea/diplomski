import java.util.*;

public class BankSystem {
private Account accArr;
Scanner Input;

public BankSystem() {
    accArr = new Account(100);
    Input = new Scanner(System.in);
}

public static void main(String[] args) {
    BankSystem bs = new BankSystem();
    bs.main();
}

public void main() {
    int Choice = 1;
    while (Choice != 0) {

        System.out.println("==========================");
        System.out.println("Please Enter Your Choice: ");
        System.out.println("1=> Main");
        System.out.println("2=> New Account");
        System.out.println("3=> Deposit Money");
        System.out.println("4=> Withdraw Money");
        System.out.println("5=> Personal Balance");
        System.out.println("6=> Money Transfer");
        System.out.println("7=> Full Customers Report:");
        System.out.println("8=> Delete Account");
        System.out.println("0=> Exit");
        System.out.println("==========================");
        System.out.print("=> ");

        try {
            Choice = Input.nextInt();
        } catch (InputMismatchException e) {
            System.err.print("! You Have Entered Wrong Value !\n");
            Input.next();
        }

        switch (Choice) {
        case 1:
            System.out.println("========Main Menu=========");
            main();
            break;
        case 2:
            System.out.println("========New Account=========");
            System.out.print("Enter The Account Number:");
            int acc = Input.nextInt();
            System.out.print("Enter The Account First Name:");
            String name = Input.next();
            System.out.print("Enter The Account Last Name:");
            String Sname = Input.next();
            System.out.print("Enter The Amount:");
            double bal = Input.nextDouble();
            Customer cust = new Customer(acc, name, Sname, bal);
            this.accArr.insert(cust);
            break;
        case 3:
            System.out.println("========Deposit Money=========");
            System.out.print("Enter Account Number:");
            acc = Input.nextInt();
            System.out.print("Enter The Amount:");
            double amount = Input.nextDouble();
            if (amount <= 0)
                System.out
                        .println("The amount can not be negative or zero.");
            else
                this.accArr.depositMoney(acc, amount);
            break;
        case 4:
            System.out.println("========Withdraw Money=========");
            System.out.print("Enter Account Number:");
            acc = Input.nextInt();
            System.out.print("Enter The Amount:");
            amount = Input.nextDouble();
            if (amount <= 0)
                System.out
                        .println("The amount can not be negative or zero.");
            else
                this.accArr.withdrawMoney(acc, amount);
            break;
        case 5:
            System.out.println("========Personal Balance=========");
            System.out.print("Enter The Account Number:");
            acc = Input.nextInt();
            this.accArr.personalDisplay(acc);
            break;
        case 6:
            System.out.println("========Money Transfer=========");
            System.out.print("Enter The Sender Account Number:");
            int fromAcc = Input.nextInt();
            System.out.print("Enter The Receiver Account Number:");
            int toAcc = Input.nextInt();
            System.out.print("Enter The Amount:");
            amount = Input.nextDouble();
            this.accArr.transferMoney(fromAcc, toAcc, amount);
            break;
        case 7:
            System.out.println("========Full Customers Report=========");
            System.out.println("Ac Num.\tName\tSurname\tBalance");
            this.accArr.displayList();
            break;
        case 8:
            System.out.println("========Delete Account=========");
            System.out.print("Enter The Account Number:");
            acc = Input.nextInt();
            this.accArr.delete(acc);
            break;
        case 9:
            break;
        case 0:
            System.out
                    .println("Thanks For Using this App we're Looking forward to see You Again :)");
            System.exit(0);
            break;
        default:
            System.out.println("Entry is not valid.\n");
            break;
        }
    }
}
}

class Customer {

private int accNum;
private String name;
private String Sname;
private double balance;

public Customer(int a, String n, String Sn, double amount) {
    accNum = a;
    name = n;
    Sname = Sn;
    balance = amount;
}

public String getname() {
    return name;
}

public String getSname() {
    return Sname;
}

public int getaccNum() {
    return accNum;
}

public double getBalance() {
    return balance;
}

public void personalDisplay() {
    System.out.println(getname() + " " + getSname() + "'s Balance is "
            + getBalance() + "$");
}

public void deposit(double amount) {
    this.balance += amount;
    System.out.println(amount + "$ has been Deposited");
}

public void withdraw(double amount) {
    if (this.balance >= amount) {
        this.balance -= amount;
        System.out.println(amount + "$ has been Withdrawed");
    } else
        System.out.println("Insufficient Balance " + balance);

}

public void display() {
    System.out.println(getaccNum() + "\t" + getname() + "\t" + getSname()
            + "\t" + getBalance() + "$");
}
}

class Account {

private Customer[] Array;
private int nElem;

public Account(int max) {
    Array = new Customer[max];
    nElem = 0;
}

public void insert(Customer newData) {
    int i, j;
        if (newData.getaccNum() <= 0)
            System.out.println("The Account ID can't be Negative");
        else
            if (find(newData.getaccNum()))
            System.out.println("This User is already exist!");
        else {
            if (newData.getBalance() < 0)
                System.out.println("Amount can't be Negative!");
            else {
            if (nElem == (Array.length - 1))
                System.out.println("Slots are Full");
            else {
                for (i = 0; i < nElem; i++)
                    if (Array[i].getaccNum() > newData.getaccNum())
                        break;

                for (j = nElem; j > i; j--)
                    Array[j] = Array[j - 1];

                Array[i] = newData;
                nElem++;
            }
        }
    }
}

public boolean delete(int del) {
    int i;
    for (i = 0; i < nElem; i++)
        if (Array[i].getaccNum() == del)
            break;

    if (i == nElem)
        return false;
    else {
        for (int j = i; j < nElem; j++) {
            Array[j] = Array[j + 1];
        }
        nElem--;
        System.out.println("Customer " + del + " has been Deleted !");
        return true;
    }
}

public boolean find(int accountId) {
    if (nElem == 0) {
        return false;
    }
    int LowBoun = 0;
    int HighBoun = nElem - 1;
    int now;
    while (true) {
        now = (LowBoun + HighBoun) / 2;
        if (this.Array[now].getaccNum() == accountId)
            return true;
        else {
            if (Array[now].getaccNum() < accountId)
                LowBoun = now + 1;
            else
                HighBoun = now - 1;
        }

        if (LowBoun > HighBoun)
            return false;
    }
}

public void transferMoney(int fromAcc, int toAcc, double amount) {
    int i, j;
    for (i = 0; i < nElem; i++) {
        if (Array[i].getaccNum() == fromAcc)
            break;
    }

    for (j = 0; j < nElem; j++) {
        if (Array[j].getaccNum() == toAcc)
            break;
    }
    Array[i].withdraw(amount);
    Array[j].deposit(amount);
    System.out.println(amount + "$ has been Transfered to Account Number:'"
            + toAcc + "'");
}

public void personalDisplay(int acc) {
    int i;
    for (i = 0; i < nElem; i++) {
        if (Array[i].getaccNum() == acc)
            break;
    }
    Array[i].personalDisplay();
}

public void depositMoney(int acc, double amount) {
    int i;
    for (i = 0; i < nElem; i++) {
        if (Array[i].getaccNum() == acc)
            break;
    }
    Array[i].deposit(amount);
}

public void withdrawMoney(int acc, double amount) {
    int i;
    for (i = 0; i < nElem; i++) {
        if (Array[i].getaccNum() == acc)
            break;
    }
    Array[i].withdraw(amount);
}

public void displayList() {
    for (int i = 0; i < nElem; i++) {
        this.Array[i].display();
    }
}
}