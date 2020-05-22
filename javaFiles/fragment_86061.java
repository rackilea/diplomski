URL url = new URL(<your URL>);

BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
String inputLine;
StringBuffer response = new StringBuffer();

while ((inputLine = in.readLine()) != null) {
  response.append(inputLine + "\n");
}

in.close();