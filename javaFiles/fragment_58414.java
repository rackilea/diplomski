URL url = new URL ("https://example.com:8080");
HttpsURLConnection connection = (HttpsURLConnection)url.openConnection();
connection.connect();

...

BufferedWriter out = new BufferedWriter(new OutputStreamWriter(connection.getOutputStream()));
out.write("Hello");
out.flush();
out.close();