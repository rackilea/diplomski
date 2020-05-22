package depandwith;

import java.util.*;
public class DepAndWith {
    public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.println("TO DEPOSIT USE POSITIVE AND, TO WITHDRAW USE NEGATIVE VALUE.\n\n");
    int amount[] = new int[10];
        for (int i = 0; i < 10; i++) {
            System.out.println("Enter amount: ");
            amount[i] = input.nextInt();
        }

        //Printing the deposit amounts:
        for (int i = 0; i < 10; i++) {
            System.out.print("Print out Deposited amount");
            if(amount[i]>0){
                System.out.print(amount[i]+", ")
            }
        }
        System.out.println();
        //Printing the withdraw amounts:
        for (int i = 0; i < 10; i++) {
            System.out.println("Print out Withdraw amount");
            if(amount[i]<0){
                System.out.print(amount[i]+", ")
            }
        }
    }
}