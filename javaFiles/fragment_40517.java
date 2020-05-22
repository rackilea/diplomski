String dateSample = "10-01-2010 21:10:05";

    String oldFormat = "dd-MM-yyyy HH:mm:ss";
    String newFormat = "yyyy-MM-dd HH:mm:ss";

    SimpleDateFormat sdf1 = new SimpleDateFormat(oldFormat);
    SimpleDateFormat sdf2 = new SimpleDateFormat(newFormat);


    try {
        System.out.println(sdf2.format(sdf1.parse(dateSample)));

    } catch (ParseException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }