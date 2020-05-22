public static String format(Object time,String f) throws ParseException   
{   
    if (time == null) 
        rteurn null;

    SimpleDateFormat sdf=new SimpleDateFormat(f);       
    System.out.println("Date:- " +sdf.format(time));        
    return sdf.format(time);        
}