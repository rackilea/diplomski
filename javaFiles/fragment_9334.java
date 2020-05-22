TimeZone utc = TimeZone.getTimeZone("UTC");
Calendar calendar = Calendar.getInstance(utc);

DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
df.setTimeZone(utc);
Date finalTime = null;

try
{
    finalTime = df.parse("01/01/2100");            
} catch (ParseException e)
{
    e.printStackTrace();
}

calendar.setTime(finalTime);