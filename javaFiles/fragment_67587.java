private void getValue(Date dateObject) 
{
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
    String timestamp = formatter.format(dateObject);
    System.out.println("Created GMT cal with date [" + timestamp + "]");
}