public static void main(String[] args) throws ParseException {
    String dateStr = "2014-01-01T21:13:00.000Z";
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSX");
    Date birthDate = sdf.parse(dateStr);
    System.out.println(birthDate);
}