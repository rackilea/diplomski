import java.util.*;
public class Slop 
{  
   public static void main(String [] args)   
   {  
     // Compare the 2 Signatures
     String control = "0x302E0215032648D0ABE03F7226239932B9293B157F3EECF863021503635EB910778742D88A880B867C45CFFDEC9970BC";
     char[] controlArray = control.toCharArray();
     String test    = "0x302E021501452CB212DBE4C8B541D02D79EF140BE617875EC7021503951DB8026549B0F9AB8FDB69F355F37A5A967424";
     char[] testArray = test.toCharArray();
     List<Integer> countArray = new ArrayList<Integer>();

     for(int j =0; j < controlArray.length; j++)
     {
         if (controlArray[j] == testArray[j])
         {
            countArray.add(1);
         }
     }
     System.out.println(countArray.size());
   }
}