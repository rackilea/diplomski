public static void main(String[] args) throws ParseException {

    String strRawData =  "261107";
    SimpleDateFormat dateParser = new SimpleDateFormat("ddMMyy"); //formatter for parsing date
    SimpleDateFormat dateFormatter = new SimpleDateFormat("dd-MM-yyyy"); //formatter for formatting date output
    Date date = dateParser.parse(strRawData);

    System.out.println(dateFormatter.format(date));
}