import java.util.Arrays;
import java.util.Scanner;

public class TakeInput {


    public static void main(String[] args)
    {
        Scanner input= new Scanner(System.in);
        System.out.println("Enter Five Numbers Between 1 and 10");
        double number;
        //set length of array which stores the user input
        double [] arr= new double[5];
        for(int i=0; i<5; i++)
        {
            System.out.println("Enter Input "+i); 

            //accept input from users

            number=input.nextDouble();
            TakeInput ti= new TakeInput();

            //prompts to renter value if value is not valid
            if(ti.validate_input(number)==true)
            {
                arr[i]=number;
            }
            else
            {
                System.out.println("Enter Number "+i+" Again");
                number=input.nextDouble();
            }
        }

        System.out.println("Array List: "+Arrays.toString(arr));
    }


    //validate user input, ensure that input is not out of range
    public boolean validate_input(double input)
    {
        boolean response;
        if(input<=1 || input >=10)
        {
            response=false;
        }
        else
        {
            response=true;
        }
        return response;
    }
}