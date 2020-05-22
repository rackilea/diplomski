public Date parseDateFromString(String date){
    if(date == null) {
        return null;
    }
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-yy'T'HH:mm:ss", Locale.US);
    try {
        return simpleDateFormat.parse(date);
    } catch (ParseException e) {
        e.printStackTrace();
        return null;
    }
}