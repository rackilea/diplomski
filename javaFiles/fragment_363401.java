public static void main(String [] args) throws ParseException{
    String dateString = "2015-07-16 17:07:21";
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    // use SimpleDateFormat to define how to PARSE the INPUT
    Date date = sdf.parse(dateString);

    // at this point you have a Date-Object with the value of
    // 1437059241000 milliseconds
    // It doesn't have a format in the way you think

    // use SimpleDateFormat to define how to FORMAT the OUTPUT
    System.out.println( sdf.format(date) );

    sdf = new SimpleDateFormat();
    System.out.println( sdf.format(date) );

  // ....
}