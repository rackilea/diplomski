import java.util.Scanner;
public class Source 
{
    private static int enterednum[]=new int[5];
    public static void main(String args[])
    {
        int num=0; // make this local variable since this need not be class property
        Scanner input = new Scanner(System.in);


        for(int count=0;count<enterednum.length;count++)
        {
            System.out.println("Enter a number.");
            num = input.nextInt();
            compare(num, count);
            enterednum[count] = num; // store the input


        }

        System.out.println("These are the number you have entered: ");
        // print numbers in array instead the array
        for(int count=0;count<enterednum.length;count++)
        {
            System.out.println(enterednum[count]);
        }
    }
    // change the method signature to let it get the number of input
    public static void compare(int num, int inputcount)
    {
        for(int count=0;count<inputcount;count++)
        {
            if(num==enterednum[count])
                System.out.println("The number has been entered before.");
        }
    }
}