public static void main(String[] args) throws ParseException {
    SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
    Date d = f.parse("2008-06-20 15:30:11.656"); // Format String to a dateobject with the format provided by the String.
    SimpleDateFormat f2 = new SimpleDateFormat("MMMM dd, yyyy"); // MMMM for full month name
    System.out.println(f2.format(d)); // Use the second format to create the desired format as String with d as input.
}