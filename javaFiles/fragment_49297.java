import java.util.Date;
import java.text.SimpleDateFormat;

import org.apache.cxf.xjc.runtime.DataTypeAdapter;

public class DateTypeAdapterWrapper {

    private static final String DATE_FORMAT = "yyyy-MM-dd";

    public static Date parseDate(String value) {
        return (DataTypeAdapter.parseDate(value));
    }

    public static String printDate(Date value) {
        String tmp = DataTypeAdapter.printDate(value);
        if(tmp == null) {
            return null;
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);
        return dateFormat.format(value);
    }
}