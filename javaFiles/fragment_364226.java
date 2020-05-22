String str = "10:12:57 pm";

    SimpleDateFormat formatter_from = new SimpleDateFormat("hh:mm:ss a", Locale.US); 

    //Locale is optional. You might want to add it to avoid any cultural differences.

    SimpleDateFormat formatter_to = new SimpleDateFormat("HH:mm", Locale.US);

    try {
        Date d = formatter_from.parse(str);

        System.out.println(formatter_to.format(d));

    } catch (ParseException e) {           
        e.printStackTrace();
    }