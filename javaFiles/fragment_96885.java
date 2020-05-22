import java.util.Date;  
import java.text.SimpleDateFormat;  

public class test  
{  
    public static void main( String[] args )  
    {  
        String myDatePattern1 = "yyyy-MM-dd";  
        String myDatePattern2 = "yyyy/MM/dd";  
        SimpleDateFormat df = new SimpleDateFormat( myDatePattern1 );  

        Date today = new Date();
        System.out.println( "Date today: " + today );
        System.out.println( "Date in pattern 1: " + df.format( today ) );

        df.applyPattern( myDatePattern2 );
        System.out.println( "Date in pattern 2: " + df.format( today ) );
    } // psvm(...)
} // class test