URL postURL = new URL("http://"+host+"/ServletPath");
HttpURLConnection conn = (HttpURLConnection) postURL.openConnection();
conn.setRequestMethod("POST");
conn.setDoOutput(true);
conn.connect();

PrintWriter out = new PrintWriter(conn.getOutputStream());
out.write("param1="+URLEncoder.encode(parameter1)+"&param2="+URLEncoder.encode(parameter2));
out.flush();