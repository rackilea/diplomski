import java.util.*;

public class Stack3{
public static void main(String []args){
    int count=0;
    int days;
    double DailyFee=0, NontaxTotal, CarType, Total,FullTotal=0;
    Scanner in=new Scanner(System.in);
    System.out.println("If there are any customer press 1 else press 0");
    int cus=in.nextInt();
    // this is sentinel loop
    while(cus!=0){
        count++;
        System.out.print("What vehical would you like to rent?\n");
        System.out.println("Enter 1 for an economy car\n");
        System.out.println("Enter 2 for a sedan car\n");
        System.out.println("Enter 3 for an SUV");
        CarType = in.nextInt();
        if (CarType == 1)
              DailyFee=31.76;
        else if(CarType == 2)
              DailyFee=40.32;
        else if(CarType == 3)
              DailyFee=43.50;

        System.out.print("Please enter the number of days rented. (Example; 3) : ");
        days = in.nextInt();
        double x=days;
        NontaxTotal = (DailyFee * x);
        Total = (NontaxTotal * 1.06);
        FullTotal+=Total;
        //included 2 decimals only
        System.out.printf("The total amount due is $ %.2f \n",Total);

        System.out.println("If there are any customer press 1 else press 0");
        cus=in.nextInt();
    }
    System.out.println("Count of customers :- "+count);
    System.out.printf("Total of the Day :- %.2f",FullTotal);
}
}