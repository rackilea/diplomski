import java.util.Scanner;

public class Loops { //use java naming convention

    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);

        int  count = 0,  score = 0, min = 0, max = 0, sum =0;
        float average = 0;//the average might not be int

        System.out.print("Please enter first score:");
        score = keyboard.nextInt();

        //add it to sum
        sum = score;
        //keep first number as min and max
        min = score;  max = score;

        count++;//increment counter

        //this is not needed, score of -1 will stop the next loop any way
        //while (score!=-1){

        while (true){

            System.out.println("the score is between 0 to 100 ");
            System.out.println("Please enter the next test score, or -1 to quit:");
            score = keyboard.nextInt();

            if((score < 0) ||(score > 100)) {
                break;
            }
            count++;//increment counter

            //you need to sum all entered numbers
            sum += score;

            //check if entered number is min
            if(score < min) {
                min = score ;
            }

            //check if entered number is max
            if(score >  max) {
                max = score ;
            }
        }

        if(count >0 ) {
            average = ((float)sum/count);
            System.out.println("The average is " +average );
            System.out.println("The min is " +min);
            System.out.println("The max is " +max);
            System.out.println("The number of test scores enter was:"+count);
        }else {
            System.err.println("No numbers entered");
        }
    }
}