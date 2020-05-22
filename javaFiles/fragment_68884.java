private String getSubStractYear ( String date )
{
    try
    {
        SimpleDateFormat sdf = new SimpleDateFormat ( "yyyyMMdd" );
        Date myDate = sdf.parse(date);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(myDate);
        calendar.add(Calendar.YEAR , -1 );

        return ( sdf.format( calendar.getTime() ) );
    }
    catch ( Exception e )
    {
        e.printStackTrace();
        return "";
    }
}