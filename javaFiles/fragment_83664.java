import java.util.Scanner;

class Life
{
    public static void main(String args[])
    {
        Scanner sc =new Scanner(System.in);

        while(true)                 //This loop will always run till we break it from inside the loop
        {
            int ip=sc.nextInt();    //Taking input as an integer
            if(ip == 42)            //If input is 42 , break the loop
                break;
            System.out.println(ip); //else print that integer and continue the loop
        }
    }
}