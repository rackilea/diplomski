ByteArrayInputStream bais = new ByteArrayInputStream(content);
BufferedReader reader = new BufferedReader(new InputStreamReader(bais, "utf-8"));

String line = null;
while ((line = reader.readLine()) != null) {
 ...
}