import java.util.Scanner;
 //done by Nadim Baraky
 //this program calculates the number of A's, C's, G's & T's;
 //it prints a statement once as you wished in case invalid characters where entered

public class ACGT_DNA {


  public static void main (String[] args) {
     //the counter is set to be 1;
     int length, counter=1; 
     int aCount =0, cCount=0, gCount =0, tCount=0;

     char ch;

     Scanner scan = new Scanner(System.in);
     System.out.print("Enter your string: ");
     String dna = scan.next();
     scan.close();
     length = dna.length();


 for(int i=0; i < length; i++) {
    ch = dna.charAt(i);

    switch (ch) {

      case 'A':   aCount++; 
                  break;
      case 'C':   cCount++;
                  break;
      case 'G':   gCount++;
                  break;
      case 'T':   tCount++;
                  break;
      default: 
         if(counter==1) { 
             System.out.println("An invalid character was entered.");
             counter++;
             //after counter is being incremented, the if statement won't be true; so no matter how invalid characters you enter, the statement will be just be printed once.
         }

    }
}

    System.out.println("A's " + aCount);
    System.out.println("C's " + cCount);    
    System.out.println("G's " + gCount);    
    System.out.println("T's " + tCount);

}