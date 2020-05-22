import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class Codechef
{
    public static void main (String[] args) throws java.lang.Exception
    {
        Object[][] Person = new Object[2][2];
        Person[0][0] = "John";
        Person[0][1] = new Integer(18);

        Person[1][0] = "Mike";
        Person[1][1] = new Integer(42);


        for(int i = 0; i < Person.length; i++)
        {
            for(int j = 0; j < Person.length; j++)
            {
                System.out.print("\t" + Person[i][j] + "\t");

                if(Person[i][j] instanceof Integer)
                {
                    if((int)Person[i][j] > 18)
                    System.out.print("18 or over");
                }
            }
            System.out.println();
        }
    }
}