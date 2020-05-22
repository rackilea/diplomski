/****************************************************
        CODED BY: MORPHEUS ExM
***************************************************/ 

import java.util.InputMismatchException;
import java.util.Scanner;
//
public class ATM {
//  
    public static void main(String[] args) {
        //
        boolean accessGranted = true;
        Scanner scan = new Scanner(System.in);
        String command;
        String name[] = new String[30];
        String user[] = new String[30];
        //
        int num[] = new int[30];
        int count = 0;
        int command_count = 0;
        //      
        while (accessGranted){
            System.out.println("Command: ");
            //
            int len = 0;
            //
            command = scan.nextLine();
            String[] val = command.split(" ");
            name[count] = val[0];
            String Name = name[count];
            user[count] = val[1];
            String openUser = user[count];
            //
            String account_name = val[1];
            //
            if (val[0].equalsIgnoreCase("open") && val.length==2){
                len=1;
                }
        //
        Account acc = new Account(openUser);//NEW
        while (len==0){
            System.out.println("Command: ");
            command = scan.nextLine();
            val = command.split(" ");
            name[count] = val[0];
             Name = name[count];
            user[count] = val[1];
             account_name = val[1];
             //
            if (val[0].equalsIgnoreCase("open") && val.length==2){
                    len=1;
                }
            acc = new Account(openUser);//NEW
        }
        command_count++;
        System.out.println("#" + acc.getAccountNo());
        //
        while (command_count!=0)
        {
            try{
                while (val.length > count ){
                    System.out.println("Command: ");
                    command = scan.nextLine();
                    val = command.split(" ");
                    name[count] = val[0];
                    Name = name[count]; 
                    //
                    if(val.length == 2){
                        user[count] = val[1];
                        openUser = user[count];
                        int Num = Integer.parseInt(user[count]);
                        if(Name.equalsIgnoreCase("Open")){
                            System.out.println("#" + acc.getAccountNo());   
                        }
                        else if(Name.equalsIgnoreCase("Deposit") || Name.equalsIgnoreCase("D")){
                            acc.Deposit(Num);
                            command_count++;
                            System.out.println("+" + Num);
                        }
                        else if(Name.equalsIgnoreCase("Withdraw") || Name.equalsIgnoreCase("W")){
                            acc.Withdraw(Num);
                            command_count++;
                            System.out.println("-" + Num);
                        }
                        else if(Name.equalsIgnoreCase("Login")){
                            System.out.println("Hello " +  account_name  );
                        }
                    }
                    else if (val.length == 1){
                        if (Name.equalsIgnoreCase("Balance") || Name.equalsIgnoreCase("B")){
                            System.out.println("= " + acc.getBalance());
                            command_count++;
                        }
                        else if(Name.equalsIgnoreCase("Quit") || Name.equalsIgnoreCase("Q")){
                            command_count=0;
                            break;
                        }
                        else if(Name.equalsIgnoreCase("Terminate") || Name.equalsIgnoreCase("T")){
                            System.out.println("ATM shutting down!");
                            System.exit(0);
                        }
                    }
                    break;
                }
            }   
            catch (InputMismatchException e) {
                    System.out.println("");
               }
        }

    }   
}
}