conn = (HttpURLConnection) url.openConnection();
conn.setRequestMethod("POST");
conn.setDoOutput(true);
String param = "username="+user.username+"&password="+user.password;
OutputStream out = conn.getOutputStream();
DataOutputStream dataOut = new DataOutputStream(out);
dataOut.writeBytes(param.trim());
InputStream in = conn.getInputStream();
BufferedReader reader = new BufferedReader(new InputStreamReader(in));
String line;
StringBuilder builder = new StringBuilder();
while((line = reader.readLine()) != null) {
    builder.append(line);
}
reader.close();
System.out.println(builder.toString());