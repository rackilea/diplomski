URL url = new URL("http://somehost");
con = url.openConnection();
con.setConnectTimeout(connectTimeout);
con.setReadTimeout(readTimeout);
inStream = con.getInputStream();
Builder parser = new Builder();
Document doc = parser.build(inStream);