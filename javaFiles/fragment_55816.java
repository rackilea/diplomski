Calendar calendar = Calendar.getInstance();       
        TimeZone tz = TimeZone.getTimeZone("America/Los_Angeles");
        calendar.setTimeZone(tz);
         System.out.println("Offset from UTC="+tz.getOffset(calendar.getTimeInMillis())/(60*60*1000)); //prints -8
        System.out.println(tz.getDisplayName(Boolean.TRUE, 0)); //prints PDT
        System.out.println(tz.getDisplayName(Boolean.TRUE, 1)); //prints Pacific Daylight Time
        System.out.println(tz.getDisplayName(Boolean.FALSE, 0));//prints PST
        System.out.println(tz.getDisplayName(Boolean.FALSE, 1));//prints Pacific Standard Time