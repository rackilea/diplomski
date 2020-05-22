import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
    public static void main(String[] args) throws Exception {

        Date d = new Date((long)1481723817*1000);
        DateFormat f = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.mmm'Z'");
        System.out.println(f.format(d));
    }
}

>>2016-12-14T14:56:57.056Z