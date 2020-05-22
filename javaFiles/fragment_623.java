public String getDateStr()
{
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    String date = dateFormat.format(this.TaskDate);
    return date;
}