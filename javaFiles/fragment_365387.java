URL url = new URL("http://www.minecraft.net/haspaid.jsp?user=somethinghere");
URLConnection conn = url.openConnection();
BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
String line = null;
while ((line = reader.readLine()) != null) {
   // parse your content here
}