URLConnection connection = new URL(url).openConnection();
connection.setDoOutput(true); // POST
connection.setRequestProperty("Accept-Charset", "UTF-8");
connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8");
try (OutputStream output = connection.getOutputStream()) {
    output.write(getEncodedQueryString(request.getParameterMap()).getBytes(StandardCharsets.UTF_8));
}
BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
StringBuilder sb = new StringBuilder();
String inputLine;
while ((inputLine = in.readLine()) != null) { sb.append(inputLine); }
in.close();