String cdate = "Sun, 24 Feb 2019 08:06:26 GMT";
    SimpleDateFormat sdf = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss zzz", Locale.ENGLISH);
    Date date = null;
    try {
        date=sdf.parse(cdate);
    } catch (ParseException e) {
        e.printStackTrace();
    }