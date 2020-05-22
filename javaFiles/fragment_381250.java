SimpleDateFormat sdf = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss");
try 
{
    Date date = (Date)sdf.parse("Wed, 08 Feb 2012 09:06:41 +0000");
    System.out.println(date);
    SimpleDateFormat day = new SimpleDateFormat("dd-MMM-yyyy");
    SimpleDateFormat time = new SimpleDateFormat("HH:mm");
    System.out.println(day.format(date));
    System.out.println(time.format(date));
} 
catch (ParseException e) 
{
    e.printStackTrace();
}