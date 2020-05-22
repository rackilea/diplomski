URL url = new URL("http://www.example.com/");
URLConnection con = url.openConnection();
InputStream in = con.getInputStream();
String encoding = con.getContentEncoding();  // ** WRONG: should use "con.getContentType()" instead but it returns something like "text/html; charset=UTF-8" so this value must be parsed to extract the actual encoding
encoding = encoding == null ? "UTF-8" : encoding;
String body = IOUtils.toString(in, encoding);
System.out.println(body);