Try This demo:

   import java.io.*;
   import java.util.*;
    class d
    {
    public static void main(String args[])
   {
        try
            {
         FileReader fr = new FileReader("String.txt");
         BufferedReader br = new BufferedReader(fr);
         String s="";
         char [] r2;
         int i=0,j=0;
         char [][]c=new char[5][12];
         while((s = br.readLine()) != null) 
         {
         r2=s.toCharArray();

         for(j=0;j<r2.length;j++)
         {
          c[i][j]=r2[j];
          System.out.print(""+c[i][j]);
          System.out.print(",");
        }
        i++;
        System.out.print("\n");
            }
        }
       catch(Exception e)
        {
         e.printStackTrace();
         }
       }
    }