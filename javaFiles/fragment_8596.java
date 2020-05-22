SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd'T'hhmmss");

    TimeZone tz = TimeZone.getTimeZone("America/Los_Angeles");
    sdf.setTimeZone(tz);

    Date start = sdf.parse("20140423T120000");