package com.ggl.testing;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class TimeZoneConversion {

    public static void main(String[] args) {
        SimpleDateFormat sdInput = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        sdInput.setTimeZone(TimeZone.getTimeZone("US/Eastern"));
        SimpleDateFormat sdOutput = new SimpleDateFormat(
                "dd/MM/yyyy HH:mm:ss Z");
        sdOutput.setTimeZone(TimeZone.getTimeZone("GMT"));

        try {
            String dateString = "28/09/2016 12:27:00";
            Date inputDate = sdInput.parse(dateString);
            System.out
                    .println(dateString + " -> " + sdOutput.format(inputDate));
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

}