package se.wederbrand.milliseconds;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class Main {        
    public static void main(String[] args) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        sdf.setTimeZone(TimeZone.getTimeZone("UTC"));

        String inputString = "00:01:30.500";

        Date date = sdf.parse("1970-01-01 " + inputString);
        System.out.println("in milliseconds: " + date.getTime());        
    }
}