Date datearr = null;
    DateFormat df1 = new SimpleDateFormat("dd-MM-yyyy");
    String dataa = "17-03-2012";
    try {
        datearr = df1.parse(dataa);
    } catch (ParseException e) {
        Toast.makeText(this, "err", 1000).show();
        return;  // do not continue in case of a parse problem!!
    }

    // "convert" the Date instance to a Calendar
    Calendar cal = Calendar.getInstance();
    cal.setTime(datearr);

    // use the Calendar the get the fields
    int dPDMonth = cal.get(Calendar.MONTH)+1;
    int dPDDay = cal.get(Calendar.DAY_OF_MONTH);
    int dPDYear = cal.get(Calendar.YEAR);

    // simplified output - no need to create strings
    System.out.println(dPDDay+"-"+dPDMonth+"-"+dPDYear);