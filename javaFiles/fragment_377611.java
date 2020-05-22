SimpleDateFormat sdfgmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    sdfgmt.setTimeZone(TimeZone.getTimeZone("GMT"));

    SimpleDateFormat sdfmad = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    sdfmad.setTimeZone(TimeZone.getTimeZone("Europe/Madrid"));

    String inpt = "2011-23-03 16:40:44";
    Date inptdate = null;
    try {
        inptdate = sdfgmt.parse(inpt);
    } catch (ParseException e) {e.printStackTrace();}

    System.out.println("GMT:\t\t" + sdfgmt.format(inptdate));
    System.out.println("Europe/Madrid:\t" + sdfmad.format(inptdate));