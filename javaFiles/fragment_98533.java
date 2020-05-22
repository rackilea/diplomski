DateFormat utcFormat = new SimpleDateFormat(patternString);
    utcFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
    DateFormat indianFormat = new SimpleDateFormat(patternString);
    indianFormat .setTimeZone(TimeZone.getTimeZone("Asia/Kolkata"));
    Date timestamp = utcFormat.parse(inputString);
    String output = indianFormat.format(timestamp);