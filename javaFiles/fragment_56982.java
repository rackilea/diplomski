//opens the URL as a stream, so it does not timeout prematurely
String u = new String("http://foobar/isbnsearch.php?isbn="+ISBN);
URL url = new URL(u);
InputStream stream = url.openStream();

r.parse(new InputSource(stream));
stream.close();