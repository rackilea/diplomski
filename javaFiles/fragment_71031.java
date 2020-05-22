import java.util.Scanner;

public class bankJavaTest {

    public static void main(String[] args){

        Scanner input = new Scanner(System.in);

        int action;

        bankJava myJavaBank = new bankJava(); //creating the bank


        do{

        System.out.println("Choose Action: ");
        System.out.println("(1) Withdraw");
        System.out.println("(2) Deposit");
        System.out.println("(3) Balance Inquiry");
        System.out.println("(4) Exit");
        action = input.nextInt();


        switch(action){



        //---------WITHDRAW------------//
        case 1 :

            System.out.println("******Withdraw******");
            myJavaBank.withdraw(); //withdrawing from it
            System.out.println("***************************");


            break;

        //---------DEPOSIT------------//
        case 2 :

            System.out.println("******Deposit******");
            myJavaBank.deposit(); //deposit from it
            System.out.println("***************************");
            break;

        //-----------Balance Inquiry-------//
        case 3 :

            System.out.println("******Balance Inquiry******");
            myJavaBank.accBalance();
            //You don't post this method but I suppose it will refer to the same bank
            System.out.println("***************************");

            break;

        case 4 :

            System.out.println("Thank you for choosing our bank!");
            break;

        default :

            System.out.println("Invalid action.");
            break;

        } 
        }while(action != 4);

    }


}