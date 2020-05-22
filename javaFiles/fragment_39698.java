String someText = "Here goes magical text";

URL url = new URL("ftp://user:password@somewebsite.com/filename.txt");
URLConnection connection = url.openConnection();

connection.setDoOutput(true);

OutputStream outStream = connection.getOutputStream();

outStream.write(someText.getBytes(Charset.forName("UTF-8"))); 
outStream.close();