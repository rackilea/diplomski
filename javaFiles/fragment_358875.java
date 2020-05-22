Connection jsoupConnection = Jsoup.connect("http://www.baidu.com/page?param=|||");
Document document = jsoupConnection.get();
URL url=new URL("http://www.baidu.com/page?param=|||");
URLConnection urlConnection = url.openConnection();
InputStream input = urlConnection.getInputStream();
byte[] entity = ByteStreams.toByteArray(input);