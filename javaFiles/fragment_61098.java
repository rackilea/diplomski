import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class TS {

    // 11PM 2015-08-12
    long base=1439348420L; 

    long[] timestamps = {
        base,
        base + 1800,
        base + 1800*2,
        base + 1800*3,
        base + 1800*4,
        base + 1800*5
    };

    // MAKE SURE THIS IS IN THE RIGHT TIMEZONE
    Calendar cal = Calendar.getInstance();
    int lastday;
    static DateFormat HHMM = new SimpleDateFormat("\"HH.mm\"");
    static DateFormat DATE_HHMM = new SimpleDateFormat("\"HH.mm yyyy-MM-dd\"");

    public void run() {
        StringBuilder sb = new StringBuilder("{");
        for (int i=0; i<timestamps.length; i++) {
            if (i>0) sb.append(", ");
            sb.append(formattedDate(timestamps[i]));
        }
        sb.append('}');
        System.out.println(sb.toString());
    }

    public String formattedDate(long unixtime) {
        String result = null;
        cal.setTimeInMillis(unixtime*1000);

        int today = cal.get(Calendar.DAY_OF_MONTH);
        if (today != lastday && lastday > 0) {
            result = DATE_HHMM.format(cal.getTime());
        } else {
            result =  HHMM.format(cal.getTime());
        }
        lastday = today;
        return result;
    }

    public static void main(String[] args) {
        TS ts = new TS();
        ts.run();
    }

}