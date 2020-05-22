Calendar c = Calendar.getInstance();
SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
String getCurrentTime = sdf.format(c.getTime());
String getTestTime="09:45";

if (getCurrentTime .compareTo(getTestTime) < 0)

{
   // Do your staff
 Log.d("Return","getTestTime less than getCurrentTime "); 
}
else
{
 Log.d("Return","getTestTime older than getCurrentTime "); 
}