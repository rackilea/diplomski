//added an import here
import java.util.ArrayList;
import java.util.Scanner;

class programTwo
{
    //main difference is the average calculation is done within a method instead of main
    public static void main( String[] args )
    {
        Scanner scan = new Scanner(System.in);
        ArrayList<Double> myArr = new ArrayList<Double>();
        double sum = 0;
        int count = 0;
        System.out.println("Enter a number to be averaged:");
        String inputs = scan.nextLine();

    while (!inputs.contains("q")) //input until user no longer wants to give input
    {

        if (count == 21)
        {
            break; //this command here jumps out of the input loop if there are 21
        }

        Scanner scan2 = new Scanner(inputs); // create a new scanner out of our single line of input
        myArr.add(scan2.nextDouble()); //simply adding to the array list
        count += 1;
        System.out.println("Please enter another number or press Q for your average");

        inputs = scan.nextLine();
    }
    Double average = calculate_average(myArr); //go to method calculate average, expect a double to be returned
    System.out.println("Your average is: " + average); 
}

private static Double calculate_average( ArrayList<Double> myArr ) //method definition
{
    Double Sum = 0.0; 
    for (Double number: myArr) //for loop that iterates through an array list
    {
        Sum += number; //add all the numbers together into a sum
    }
    return Sum / myArr.size(); //return the sum divided by the number of numbers in the array list
}
}