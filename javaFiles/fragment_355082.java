SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZZZZ");

try {
    Date date = format.parse("2019-05-14T17:21:04+0000");
    System.out.println(date);
} catch (ParseException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
}