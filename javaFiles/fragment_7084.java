public String datetoString(Date date)
{
    SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
    Date today = Calendar.getInstance().getTime();
    String result = df.format(today);       // <= You're actually formatting "today" date, not "date"
    return result;
}