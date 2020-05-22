public static void main(String[] args) throws Exception {
    String target = "Mon Mar 25 00:00:00 IST 2013";
    DateFormat df = new SimpleDateFormat("EEE MMM dd kk:mm:ss z yyyy", Locale.ENGLISH);
    Date result =  df.parse(target);  
    System.out.println(result);
}