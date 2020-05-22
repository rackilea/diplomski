package com.sandbox;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class Sandbox {

    public static void main(String[] args) {
        DateTimeFormatter NBSfmt = DateTimeFormat.forPattern("EEE, dd MMM yyyy HH:mm:ss Z");

        String date = "Fri, 22 Feb 2013 00:00:00 +0000";
        DateTime datetime = NBSfmt.parseDateTime(date);
        System.out.println(datetime.toDateTime(DateTimeZone.UTC).toString());
    }

}