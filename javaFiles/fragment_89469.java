import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Test{

    public static void main (String[] args)
    {
        String str="201411W3";
        String[] strSplitted = str.split("W");

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.MONTH, Integer.parseInt(strSplitted[0].substring(4,6))-1);
        calendar.set(Calendar.YEAR, Integer.parseInt(strSplitted[0].substring(0,4)));
        calendar.set(Calendar.DAY_OF_MONTH, 1);

        if(calendar.get(Calendar.DAY_OF_WEEK)==7)
        {
            calendar.set(Calendar.WEEK_OF_MONTH, Integer.parseInt(strSplitted[1])+1);
        }   
        else
        {
            calendar.set(Calendar.WEEK_OF_MONTH, Integer.parseInt(strSplitted[1]));
        }

        calendar.set(Calendar.DAY_OF_WEEK, Calendar.FRIDAY);
        String formattedDate = new SimpleDateFormat("yyyy-MM-dd").format(calendar.getTime());

        System.out.println(formattedDate);
    }
}