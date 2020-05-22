import java.text.DecimalFormat;
import java.util.Scanner;

public class ProblemSet3_1 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        DecimalFormat dec = new DecimalFormat();

        int snum = 0;
        int height = 0;
        int add = 0;
        double avg = 0;
        int largest = 0;
        int smallest = 0; 


        System.out.print("How much students are in your class?" + '\n');
        snum = input.nextInt(); 


        for (int i = 1; i <= snum; i++) {
            System.out.print("How tall is student #" + i + "?" + '\n');
            height = input.nextInt();

            add += height;
            avg = add / i;
            if(i == 1) {
                smallest = height;
            }
            else if(height < smallest){
                smallest = height;
            }
            if (height > largest) {
                largest = height;
            }

        }
        System.out.print("The average height is " + avg + ", while the tallest is " + largest + " , and the shortest is " + smallest +  ".");

    }
}