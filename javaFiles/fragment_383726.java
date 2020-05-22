URL uri = new URL("http://codebits.eu/s/calendar.ics");
HttpURLConnection con = (HttpURLConnection)uri.openConnection();
System.out.println(con.getResponseCode());
System.out.println(con.getHeaderField("Location"));

uri = new URL(con.getHeaderField("Location"));
con = (HttpURLConnection)uri.openConnection();
InputStream in = con.getInputStream();