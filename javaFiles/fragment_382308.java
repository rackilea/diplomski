import java.io.*;
import java.util.*;
public class Project2
{
    public static void main (String args[]) throws Exception
    {
        // Create a scanner to read from keyboard
        Scanner infile = new Scanner ( new FileReader(args[0]) );
        int count=0,sum=0, largest=Integer.MIN_VALUE,smallest=Integer.MAX_VALUE, evens=0, odds=0;
        double average=0.0;

        while (infile.hasNext() == true ) {
            count += 1;
            sum += infile.nextInt();
        }
        System.out.println("Count: " + count + "\tSum: " + sum);
    }
}