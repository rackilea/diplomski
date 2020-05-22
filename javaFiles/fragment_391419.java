import java.util.*;
import java.text.*;

public class dateTimeArr {
    static Scanner input = new Scanner(System.in).useDelimiter("\r\n");
    static String now=new String();
    static String later=new String();
    static String dateTimeArr = new String();

    public static void main(String[] args) 
    {   
        String dateTime=getCurrentDateTime();

        System.out.println("What are you doing now?");
        now=input.next();
        System.out.println("You are doing " +now+ " at " + dateTime);

        dateTime=getCurrentDateTime();
        System.out.println("What are you doing later?");
        later=input.next();
        System.out.println("You are doing " + later + " at " + dateTime);
    }

    public static String getCurrentDateTime(){
        Date theDate = new Date();
        String currentDateTime = (theDate.getDate() + "/"
            + (theDate.getMonth() + 1) + "/" + (theDate.getYear() + 1900) + " "
            + theDate.getHours() + ":" + theDate.getMinutes() + ":" + theDate
            .getSeconds());

        return currentDateTime;
    }
}