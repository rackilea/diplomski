URL hh= new URL("http://hh.ru");
URLConnection connection = hh.openConnection();
String redirect = connection.getHeaderField("Location");
if (redirect != null){
    connection = new URL(redirect).openConnection();
}
BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
String inputLine;
System.out.println();
while ((inputLine = in.readLine()) != null) {
    System.out.println(inputLine);
}