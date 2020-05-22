import java.text.SimpleDateFormat;
import java.util.*;

public class Time extends Database{
    // class member defined in the class but not inside a method.
    private int intTime = 0;
    public Time(){
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat ("HH:mm:ss");
        String stringTime = sdf.format (cal.getTime());

        // vars defined here, will be gone when method execution is done.

        stringTime = stringTime.substring(3,5); // retrieve the minutes (is recorded as string)

        // setting the intTime of the instance. it will be available even when method execution is done.
        intTime = Integer.parseInt(stringTime);
    }

    public String getStringTime() {
        return intTime;
    }

    public static void main (String[] args) {
        // code here
    }
}