public static String getDay(Date date){

    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEEE");
    //System.out.println("DAY "+simpleDateFormat.format(date).toUpperCase());                       
    return simpleDateFormat.format(date).toUpperCase();
}