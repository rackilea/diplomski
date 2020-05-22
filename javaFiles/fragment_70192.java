import java.util.Scanner;
public class Assignment1Q3
{
    public static void main(String[] args) 
    { 
    Scanner in = new Scanner(System.in);
    System.out.print("Please enter the first time: ");
    int fTime = in.nextInt();
    System.out.print("Please enter second time: ");
    int lTime = in.nextInt();
    int tDifference = Math.abs(fTime - lTime);
    String strTDiff = String.valueOf(tDifference);
    int length = strTDiff.length();
    String hours = "";
    String minutes = "";

    if (length == 4)
    {
        hours = strTDiff.substring(0, 2);
        minutes = strTDiff.substring(3, 5);
    }
    else if (length == 3)
    {
        hours = strTDiff.substring(0);
        minutes = strTDiff.substring(2, 4);
    }
    else
    {
        hours = ("0");
        minutes = strTDiff.substring(0, 1);
    }
    System.out.println(hours + " hours " + minutes + " minutes");
    }
}