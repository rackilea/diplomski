public static String format(Object time,String f) throws ParseException   
{      
    SimpleDateFormat sdf=new SimpleDateFormat(f);       
    System.out.println("Date:- " +sdf.format(time));        
    return sdf.format(time);        
}