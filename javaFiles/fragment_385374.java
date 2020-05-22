InputStreamReader inp = new InputStreamReader(in, Charset.forName("ISO-8859-2"));
BufferedReader rd = new BufferedReader(inp);
String l;
while ((l = rd.readLine()) != null) {
   ...
}