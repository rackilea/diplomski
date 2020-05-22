URL url = new URL("http://example.sitedemo.service.php");
HttpURLConnection conn = (HttpURLConnection) url.openConnection();
conn.setRequestMethod("POST");
Uri.Builder builder = new Uri.Builder().appendQueryParameter("username", "maven")
                                       .appendQueryParameter("password", "123");
String query = builder.build().getEncodedQuery();

OutputStream os = conn.getOutputStream();
BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"));
writer.write(query);
writer.flush();
writer.close();
os.close();

conn.connect();

InputStream in = new BufferedInputStream(conn.getInputStream());
response = IOUtils.toString(in, "UTF-8");