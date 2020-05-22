public String getGmtMillis(Date time)
{
    if (time == null)
    {
        return "";
    }
    DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZZZ");
    df.setTimeZone(TimeZone.getTimeZone("GMT"));
    return df.format(time);
}