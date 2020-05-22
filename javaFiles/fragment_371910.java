public void dateFormatMonth(String day, String month) throws ParseException {
    SimpleDateFormat fromUser = new SimpleDateFormat("dd/MM");
    SimpleDateFormat myFormat = new SimpleDateFormat("EEEE MMMM dd", Locale.US);
    try {
        reformattedStr = myFormat.format(fromUser.parse(day + "/" + month));
    } catch (ParseException e) {
        e.printStackTrace();
    }
    Log.d(LOG_TAG,"day formatted"+newDateStr);
}