package tester;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BankApp {

    static class BankAccount {
        private String name;
        private int accNum;
        private double initiateAmount;

        public BankAccount() {
            this.name = null;
            this.accNum = 0;
            this.initiateAmount = 0;
        }

        public void setAccNum(int accNum) {
            this.accNum = accNum;
        }

        public void setInitiateAmount(double initiateAmount) {
            this.initiateAmount = initiateAmount;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return name + "\t" + accNum + "\t" + initiateAmount;
        }
    }

    public static void main(String[] args) {
        List<BankAccount> bankAccounts = new ArrayList<BankAccount>();
        Scanner sc = new Scanner(System.in);
        while(true){
        System.out.println("WELCOME TO OUR BANK!\n\n"
                + "Choose your option:\n"
                + "1. Create new account\n"
                + "2. View all the accounts property\n"
                + "3. Quit\n");

            int option = sc.nextInt();
            sc.nextLine();
            switch(option){
                case 1:
                    BankAccount account = new BankAccount();
                    System.out.println("Enter your full name:");
                    account.setName(sc.nextLine());
                    System.out.println("Choose an account number:");
                    account.setAccNum(sc.nextInt());                    
                    System.out.println("Enter an initiating amount:");
                    account.setInitiateAmount(sc.nextDouble());
                    bankAccounts.add(account);
                    break;
                case 2:
                    System.out.println("Name\tAcc No\tAmount");
                    for (BankAccount bankAccount : bankAccounts) {
                        System.out.println(bankAccount);
                    }
                    System.out.println("\n\n");
                    break;
                case 3:
                    return;
            }
        }
    }
}