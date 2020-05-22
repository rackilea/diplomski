import java.util.Scanner;
public class one {


    public static void main(String[] args) {
    Scanner Scanner = new Scanner (System.in);

        int counter;
        int number = 1;
        int total;
        float average;
        total = 0;
        counter = 0;



        while(number != 0){
             System.out.println("Enter the number 0 to end: ");
             number = Scanner.nextInt();
             System.out.printf("%d", number);

            total = total + number;
            counter = counter + 1;


    }
        if(counter != 0){

        average =  ((float)total /(float)counter);

             System.out.printf("Average is %.2f\n", average);
        }
        else{
            System.out.println("No valid numbers have been entered.");
            //return 0;
         }
     }
}