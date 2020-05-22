BufferedReader reader = new BufferedReader(new InputStreamReader(http.getInputStream()));
StringBuilder sb = new StringBuilder();
String line = null;
while ((line = reader.readLine()) != null) {
    sb.append(line + "\n");
}
reader.close();
String json_string = sb.toString();           // your json data