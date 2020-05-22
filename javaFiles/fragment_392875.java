URL url = new URL("http://myurl.com");
URLConnection conn = url.openConnection();
BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
String input = "";
while((input = reader.readLine())!=null) {
    System.out.println(input);
}