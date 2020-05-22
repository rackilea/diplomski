import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Pract1
{
    public static void main (String[] args)
    {
        String array = ""; //initialize an empty string that will hold the value from the keyboard
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // initialize the BufferedReader

        // while "stop" is not typed on the console, keep running
        while(!array.equals("stop")) {
            System.out.println("Enter the Array: ");
            try {
                array = br.readLine(); // read from the console
                System.out.println("Array:" + array);
                for(int i=0; i<array.length(); i++) { //loop through the input and show the chars
                    System.out.println("Character "+(i+1)+" is: " +array.charAt(i));
                }

            } catch (Exception e) { // catch any exception and show only the message, not the entire stackTrace
                System.out.println("Error: " +  e.getMessage());
            }
            System.out.println("");
        }

    }
}