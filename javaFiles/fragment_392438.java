long start = System.currentTimeMillis();
HttpClient client = new DefaultHttpClient();
HttpGet request = new HttpGet("http://foo.com/cats.jpg");
HttpResponse response = client.execute(request);
String size = response.getLastHeader("Content-Length").getValue();
long end = System.currentTimeMillis();
System.out.println("It took "+(end-start)+" milliseconds and the file is "+
    size+" bytes long");