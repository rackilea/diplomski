import java.util.*;
import java.text.*;
import java.math.*;
import java.util.Scanner; 
public class Solution4 {

public static void main(String[] args) {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    Scanner in=new Scanner(System.in);
    Scanner tin=new Scanner(System.in);
    int tc=in.nextInt();
    String [] strA=new String[tc];

    for(int i=0;i<strA.length;i++){
      if(tin.hasNextLine()) //if input is there
        strA[i]=tin.nextLine();
    }       

    for(int i=0;i<strA.length;i++){
         int d=0;
         if(strA[i]!=null) //this will be true when the input is less
         {
           String str=strA[i];
           int k=0;
           for(int j=1;j<str.length();j++){
               if(str.charAt(k)==str.charAt(j))
                    d++;
               else
                  k=j; 
           }
         }
     System.out.println(d);
   }
}