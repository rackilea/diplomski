import java.util.*;
import java.lang.*;
import java.text.*;

class Main
{
    public static void main (String[] args) throws java.lang.Exception
    {
                DecimalFormat df = new DecimalFormat("#.##########");

        float fileLengthMegabytes1 = (float) 388 / 1000000;
        float fileLengthMegabytes2 = (float) 388 / 1048576;
        System.out.println("MB1 in Scientific Notation: " + 
                            fileLengthMegabytes1);        
        System.out.println("MB1 in Decimal Notation: " + 
                            df.format(fileLengthMegabytes1));
        System.out.println("MB2 in Scientific Notation: " + 
                            fileLengthMegabytes2);        
        System.out.println("MB2 in Decimal Notation: " + 
                            df.format(fileLengthMegabytes2));
        }
}