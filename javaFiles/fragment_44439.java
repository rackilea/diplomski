public String getCurrentDate()
{
    DateFormat dateFormat = new SimpleDateFormat("MM.dd.yy.HH.mm");
    Date date = new Date();
    String date = dateFormat.format(date);
    return date;
}