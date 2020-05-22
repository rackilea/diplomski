import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.text.ParseException;

public class ConvertDate 
{
    private static final DateFormat DEFAULT_FORMAT;

    static
    {
        DEFAULT_FORMAT = new SimpleDateFormat("MM-dd-yyyy");
        DEFAULT_FORMAT.setLenient(false);
    }

    public static void main(String[] args) 
    {
        for (String dateString : args)
        {
            try
            {
                Date date = DEFAULT_FORMAT.parse(dateString);
                System.out.println(date);
            }
            catch (ParseException e)
            {
                System.out.println("invalid date string: " + dateString);
            }
        }
    }
}