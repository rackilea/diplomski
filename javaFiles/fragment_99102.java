public static void main(String[] args) 
{
    try 
    {
        final String DATE_FORMAT_NOW = "MM/dd/yyyy HH:mm:ss";
        final DateFormat dateFormat  = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss", Locale.US);

        Date sample  = new Date();
        int iMinutes = 30;//minutes added by the user

        Calendar cal = Calendar.getInstance();

        cal.add(Calendar.MINUTE, Integer.valueOf(sample.getMinutes()));

        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_NOW);
        String dt            = sdf.format(cal.getTime());

        System.out.println("Current Date and time:"+sample);
        System.out.println("Date and time with added Minutes : " + (dateFormat.parse(dt)));
    } 
    catch (ParseException ex) 
    {
        Logger.getLogger(NewMain.class.getName()).log(Level.SEVERE, null, ex);
    }
}