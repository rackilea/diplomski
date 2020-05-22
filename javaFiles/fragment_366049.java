package binarywa;
import java.util.*;

public class binaryadd {
    public static void main(String args[])
    {
        Scanner scan=new Scanner(System.in);
        String g=scan.next();
        String s[]=g.split("");
        int i,x=0;


        for(i=s.length-1;i>=0;i--)
        {

         x+=Integer.parseInt(s[i])*Math.pow(2,i);
         }  

    }

}