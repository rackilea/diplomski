String urlParameters = "param1=a&param2=b&param3=c";
URL url = new URL("http://example.com/index.php");
URLConnection conn = url.openConnection();

conn.setDoOutput(true);

OutputStreamWriter writer = new OutputStreamWriter(conn.getOutputStream());

writer.write(urlParameters);
writer.flush();

String line;
BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));

while ((line = reader.readLine()) != null) {
    System.out.println(line);
}
writer.close();
reader.close();