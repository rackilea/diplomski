import java.io.IOException;
import java.util.Scanner;

public class ASCIIArt {
    public static void main(String[] args) throws IOException {

        while (true)
        {
            Scanner keyboard = new Scanner(System.in);

            System.out.println("Chose a letter to print: E, T, F, Z, I.");

            String asciiString = keyboard.next();

            switch (asciiString.charAt(0)) {

                case 'E': {
                    System.out.println("*****");
                    System.out.println("*    ");
                    System.out.println("*****");
                    System.out.println("*    ");
                    System.out.println("*****");
                    break;
                }
                case 'T': {
                    System.out.println("*****");
                    System.out.println("  *  ");
                    System.out.println("  *  ");
                    System.out.println("  *  ");
                    System.out.println("  *  ");
                    break;
                }
                case 'F': {
                    System.out.println("*****");
                    System.out.println("*    ");
                    System.out.println("*****");
                    System.out.println("*    ");
                    System.out.println("*    ");
                    break;
                }
                case 'Z': {
                    System.out.println("*****");
                    System.out.println("   * ");
                    System.out.println("  *  ");
                    System.out.println(" *   ");
                    System.out.println("*****");
                    break;
                }
                case 'I': {
                    System.out.println("*****");
                    System.out.println("  *  ");
                    System.out.println("  *  ");
                    System.out.println("  *  ");
                    System.out.println("*****");
                    break;  
                }
                default:
                {
                    System.out.println("Invalid char - press anykey");
                    System.in.read();                       
                }       
            }  
        }

    }

    public static void functionDumpText() throws IOException
    {

    }
}