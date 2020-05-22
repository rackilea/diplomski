public static void main(String[] args) throws ParseException {
    String date = "10-10-2018";

    SimpleDateFormat givenFormat = new SimpleDateFormat("dd-MM-yyyy");  
    SimpleDateFormat newFormat = new SimpleDateFormat("dd-MMM-yyyy");


    Date givenDate=givenFormat.parse(date); 
    System.out.println(givenDate);


    String newDate=newFormat.format(givenDate); 
    System.out.println(newDate);
}