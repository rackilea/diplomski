con.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
con.setRequestProperty("Accept-Charset", "UTF-8");
con.setRequestProperty("Authorization", "key=...............");

String str1 = "{\"to\":\"/topics/1\",\"notification\":\"title\":\"";
String str2 = "Hello 我";
String str3 = "\"}}";
String urlParameters = str1+str2+str3;
con.setDoOutput(true);
OutputStreamWriter wr = new OutputStreamWriter(con.getOutputStream(), "UTF-8");

wr.write(urlParameters);
wr.flush();
wr.close();
con.getResponseCode();