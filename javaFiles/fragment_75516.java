Date date = null;
    boolean checkformat;
    try {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/dd/MM");
        dateFormat.setLenient(false);
        date = dateFormat.parse("2013/25/09");
    } catch (ParseException ex) {
        ex.printStackTrace();
    }
    if (date == null) {
        checkformat = false;
    } else {
        checkformat = true;
    }

    System.out.println(checkformat);