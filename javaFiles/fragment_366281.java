import java.util.Scanner;

public class ReverseCompliment 
{
   public static void main(String[] args)
   {
      Scanner in = new Scanner(System.in);
      String seqFirst = "0";
      String seqSecond = "0";
      String seqReverseCompliment = "";

      System.out.print("Enter the first sequence: ");
      seqFirst = in.next();
      System.out.print("Enter the second sequence: ");
      seqSecond = in.next();

      for ( int i = 0; i < seqFirst.length(); i++)
      {
         if ( seqFirst.charAt(i) == 'A')
         {
            seqReverseCompliment = "T" + seqReverseCompliment;
         }
         else if ( seqFirst.charAt(i) == 'T')
         {
            seqReverseCompliment = "A" + seqReverseCompliment;
         }
         else if ( seqFirst.charAt(i) == 'C')
         {
            seqReverseCompliment = "G" + seqReverseCompliment;
         }
         else if ( seqFirst.charAt(i) == 'G')
         {
            seqReverseCompliment = "C" + seqReverseCompliment;
         }
         else
         {
            System.out.println("incorrect input");
         }
      }
       if ( seqSecond.equals(seqReverseCompliment) )
       {
          System.out.println("These are reverse compliments");
       }
       else if (
       {
          System.out.println("These are not reverse compliments");
       }
   }
}