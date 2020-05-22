import java.util.*;
import java.io.*;

public class Test2
{
    public static void main (String args[])
    {
        int i, n;
        int[] myList= new int[100];
        Scanner keyboard = new Scanner(System.in);
        System.out.println ("n= ");
        n = keyboard.nextInt();
        for (i=0; i<n; i++)
        {
            System.out.println ("myList[" + i + "]= ");
            myList[i] = keyboard.nextInt();
        }
        for (i=0; i<n; i++)
            System.out.println (myList[i]);

        keyboard.close();
    }

}