urlConnection.connect();
is = urlConnection.getInputStream();
BufferedReader reader = new BufferedReader(new InputStreamReader(is));
StringBuilder sb = new StringBuilder();
String line;
while ((line = reader.readLine()) != null) {
      sb.append(line + "\n");
}
is.close();
json = sb.toString();
jObj = new JSONObject(json);