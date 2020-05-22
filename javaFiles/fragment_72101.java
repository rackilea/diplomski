/**
* @author Amir
* Driver class
*/

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;


public class Driver {

/**
 * main static method
 * @param args
 */
public static void main (String [] args) throws IOException  {  
    //SuperOutput so = new SuperOutput("csis.txt");
    PrintWriter pw = new PrintWriter(new FileWriter ("csis.txt"));
    InfixToPostfix infixToPostfix = new InfixToPostfix(pw);

    System.out.println("Hello and welcome to Amir's magical infix-to-postfix converter!");
    pw.println("Hello and welcome to Amir's magical infix-to-postfix converter!");
    System.out.println("Please wait while I fetch 'infix.txt'...");
    pw.println("Please wait while I fetch 'infix.txt'...");

    try {
        System.out.println("The original txt file contains as follows: " + Files.readAllLines(Paths.get("infix.txt")));
        pw.println("The original txt file contains as follows: " + Files.readAllLines(Paths.get("infix.txt")));
    } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
    //infixToPostfix.getInfix();
    infixToPostfix.getInfix();
    pw.close();


}
}