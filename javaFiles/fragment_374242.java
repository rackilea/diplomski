String str = "26/08/1994";

    SimpleDateFormat inputFormatter = new SimpleDateFormat("dd/MM/yyyy"); //please notice the    capital M
    SimpleDateFormat outputFormatter = new SimpleDateFormat("MM/dd");

    try {
        Date date = inputFormatter.parse(str);
        String text = outputFormatter.format(date);
        listPubdate.setText(text);
    } catch (ParseException e ) {
        e.printStackTrace();
    }