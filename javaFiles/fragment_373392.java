import java.util.Scanner;

public class Example {
public static void main (String [] args) {
       Scanner in= new Scanner (System.in);
       String cad = in.nextLine();
       System.out.println (cad);
       System.out.println ("The length is:" + cad.length() - 1); //you can remove -1
       }
}