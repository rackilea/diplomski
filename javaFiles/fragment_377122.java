import java.util.*;
public class example
{
public static void main(String[]args)
{
    int i = 1;
    int a = 4;
    while( i < 4 )
        {
            i++;
            a--;
            try {
            // thread to sleep for 1000 milliseconds
           Thread.sleep(100);
           } catch (Exception e) {
           System.out.println(e);
           }
            System.out.println("\t\t\t\t The Game Begins In...");
            System.out.print("\t\t\t\t " + a);
        }

        }
   }

Output

The Game Begins In...
                 3               The Game Begins In...
                 2               The Game Begins In...
                 1