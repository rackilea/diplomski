import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.DateFormat;
import java.util.TimeZone;

public class Main
{
    public static void main(String[] args){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");
        try{
            Date date = sdf.parse("2019-06-17T20:27:23.706Z");
            System.out.println(date);
        }
        catch(Exception pe){
            System.out.println(pe);
        }

    }
}