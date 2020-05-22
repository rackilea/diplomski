/*
 * @Author: Louis Krueger
 * @Desc: Homework assignment #2 exception handling
 * @Version: 1.1
 */

package paymentApplication;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MainHandle {

        public static ArrayList<String> saPaymentList  = new ArrayList<String>();

    public static void main(String[] args) {
        boolean bSkipTrans = false;
        String sFileName = "";
        String sPaymentInfo = "";
        String[] saPaymentInfo = null;
        Scanner keyBoard = new Scanner(System.in);
        ArrayList<Payment> alPayments = new ArrayList<Payment>();

        try{
            System.out.println("Enter the file name to be read: ");
            sFileName = keyBoard.nextLine();
            Scanner inputStream = new Scanner(new FileInputStream("details.txt"));
            System.out.println("Test1");
            //loop to Create arraylist of PaymentInfo objects
            while(inputStream.hasNextLine()) {
                try{
                    bSkipTrans = false;
                    Payment Payment = new Payment();
                    sPaymentInfo = inputStream.nextLine();
                    saPaymentInfo = sPaymentInfo.split(";");
                    if(saPaymentInfo.length == 1){
                        bSkipTrans = true;
                        throw new InvalidTransactionException();
                    }else{
                        if(saPaymentInfo.length > 1){
                            if (isInteger(saPaymentInfo[1]) == true){
                                Payment.setiTransValue(Integer.parseInt(saPaymentInfo[1]));
                            }else{
                                //throw exception
                                bSkipTrans = true;
                                throw new InvalidTransactionException("Error#1");
                            }
                        }
                        if(saPaymentInfo.length > 4){
                        Payment.setsCreditNumber(saPaymentInfo[4]);
                        }
                        if(saPaymentInfo.length > 3){
                        Payment.setsDate(saPaymentInfo[3]);
                        }
                        if(saPaymentInfo.length > 2){
                        Payment.setsName(saPaymentInfo[2]);
                        }
                        if(saPaymentInfo.length > 0){
                            if(saPaymentInfo[0] != "Cash"|saPaymentInfo[0] != "Credit"){
                                //throws exception
                                Payment.setsTransType(saPaymentInfo[0]);
                            }else{
                                bSkipTrans = true;
                                throw new InvalidTransactionException("Error#2");
                            }
                        }
                    }
                    if(bSkipTrans == true){
                        //throw exception
                        bSkipTrans = true;
                        throw new InvalidTransactionException("Empty line");
                    }else{
                        System.out.println(Payment.toString());
                        System.out.println("Payment Added");
                        System.out.println("-------------");
                        alPayments.add(Payment);
                    }

                } catch (InvalidTransactionException e) {
                    System.out.println("InvalidTransactionException thrown");
                }
            }

            inputStream.close();
        }catch(InputMismatchException e){
            System.out.println("Error 1 has occured: " + e.getMessage());
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        finally{
            System.out.println("Finally statement reached");
            keyBoard.close();
            System.exit(0);
        }
    }
    public static boolean isInteger(String s) {
        try { 
            Integer.parseInt(s); 
        } catch(NumberFormatException e) { 
            return false; 
        }
        // only got here if we didn't return false
        return true;
    }

}