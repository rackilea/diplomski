import java.io.*;
import javax.swing.JOptionPane;

public class Doge {

    public static void main(String[] args) 
    {
        int start = 0;
        int end = 0;
        int step = 0;
        String input = "";
        String result = "";
        boolean invalidInput = false;
        //String y = "Y";
        //String n = "N";

        //reuse same BufferedReader
        BufferedReader in2 = new BufferedReader (
                new InputStreamReader (System.in));

        //use do while to have statement run once then only check retry 
        do
        {
            try 
            {
                do
                {
                    System.out.println("Input starting number: ");
                    input = in2.readLine();
                    start = Integer.parseInt(input);

                    System.out.println("Input ending number: ");
                    input = in2.readLine();
                    end = Integer.parseInt(input);

                    if (start >= end)
                    {
                        System.out.println("Starting number should be lesser than the ending number.");
                        invalidInput = true;
                    }
                    else
                        invalidInput = false;
                } while (invalidInput);  //loop as long as the start >= end

                System.out.println("Input step number: ");
                input = in2.readLine();
                step = Integer.parseInt(input);
            }
            catch (IOException e)
            {
                System.out.println("Error");
            }

            System.out.println("");

            while (start<=end)
            {
                System.out.println(start);
                start = start+step;
            }

            try 
            {
                System.out.print("Do you want to retry (Y/N)? ");
                result = in2.readLine();
                //it will exit if answer is "N" or "n"
                //check whether result is String n (ignore case)
                //if (n.equalsIgnoreCase(result))
                //only accept "n"
                if ("n".equals(result))
                    System.exit(0);
            }
            catch(IOException e)
            {
                System.out.println("Error");
            }
        //} while (y.equalsIgnoreCase(result)); //loop if "y" or "Y"
        } while ("y".equals(result));

        //if here have other process, then your result that is neither 'Y' nor 'N' will run here    
    }
}