InputStream in = address.openStream();
BufferedReader reader = new BufferedReader(new InputStreamReader(in));
StringBuilder result = new StringBuilder();
String line;
while((line = reader.readLine()) != null) {
    result.append(line);
}
System.out.println(result.toString());