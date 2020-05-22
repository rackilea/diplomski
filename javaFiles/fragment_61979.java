package inter;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Inter {

    public static void main(String []args){
    int count=0;
    int days;
    int cus = 10; // added
    double DailyFee=0, NontaxTotal, CarType, Total,FullTotal=0;
    boolean F1 = false, F2 = false;
    Scanner in=new Scanner(System.in);

    while (cus != 0) {

        while (true) {  
            System.out.println("If there are any customer press 1 else press 0");
        try {           
            cus=in.nextInt();
            if (cus == 0 || cus == 1) {  
                break;
            } else {
                System.out.println("Number must be either 1 or 0");
            }
        } catch (InputMismatchException ex) {
            System.out.println("Invalid entry");
            in.next();
        }
    }

        if(cus == 1) {           
            while(F1 == false) {
                F1 = true;
                count++;
                System.out.print("What vehical would you like to rent?\n");
                System.out.println("Enter 1 for an economy car");
                System.out.println("Enter 2 for a sedan car");
                System.out.println("Enter 3 for an SUV");
                try {
                    CarType = in.nextInt();
                    if (CarType <= 0 || CarType >= 4) {
                        System.out.print("Number must be 1-3\n");
                        System.out.println("Please enter 1 for an economy car");
                        System.out.println("Enter 2 for a sedan car");
                        System.out.println("Enter 3 for an SUV");
                        F1 = false;
                    } else {
                         if (CarType == 1) {
                             F1 = true;
                              DailyFee=31.76;
                    } else if(CarType == 2) {
                            F1 = true;
                              DailyFee=40.32;
                    } else if(CarType == 3) {
                            F1 = true;
                              DailyFee=47.56;
                    }
                    while (F2 == false) {
                        F2 = true;
                        try { 
                            System.out.print("Please enter the number of days rented. (Example; 3) : ");                           
                            days = in.nextInt();
                            if (days <= 0) {
                                System.out.println("Number of days must be more than zero");
                                F2 = false;
                            } else {
                                //days = in.nextInt();
                                double x=days;
                                NontaxTotal = (DailyFee * x);
                                Total = (NontaxTotal * 1.06);
                                FullTotal+=Total;
                            }
                        } catch(InputMismatchException ex) {
                            System.out.println("Answer must be a number");
                            F2 = false;
                            in.next();
                            }
                        }
                    F2 = false;
                    }
                } catch (InputMismatchException ex) {
                    F1 = false;
                    System.out.println("Answer must be a number"); 
                    in.next();
                }
            }
            F1 = false;
        }
    }
    System.out.println("Count of customers : " + count);
    System.out.printf("Total of the Day : $ %.2f", FullTotal);
    }
}