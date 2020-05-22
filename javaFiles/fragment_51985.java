public Date stringToDateReport(String s){
    DateFormat format;
    Date date = null;

    format = new SimpleDateFormat("dd-MM-yyyy");

    if(s.length()==4) {
        format = new SimpleDateFormat("yyyy");
    }
    try {
        date = (Date)format.parse(s);
    } catch (ParseException e) {
        //you should do a real logging here
        e.printStackTrace();
    }
    return date;
}