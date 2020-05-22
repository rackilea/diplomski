public static long tokenTimeDuration(String loginTime, String expiryTime){
     DateTimeFormatter FMT = DateTimeFormat.forPattern("EEE MMM dd HH:mm:ss a z yyyy");
        final DateTime dt1 = new DateTime(FMT.parseDateTime(loginTime).withZone(DateTimeZone.getDefault()));
        Log.i("du_loginTimeAfterParsing",dt1.toString());

        final DateTime dt2 = new DateTime(FMT.parseDateTime(expiryTime).withZone(DateTimeZone.getDefault()));
        Log.i("du_expiryTimeAfterParsing",dt2.toString());

        long diff = dt2.getMillis() - dt1.getMillis();

        Log.i("du_tokenExpiryDuration", diff + "");    
        return diff;
}