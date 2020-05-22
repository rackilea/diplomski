for (int i=0;i<calItem.size();i++){
    String string = calItem.get(i).date_course;
    DateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
    Date date = format.parse(string);
    calItem.get(i).setDate(date);
}