BasicHttpParams params = new BasicHttpParams();
SchemeRegistry schreg = new SchemeRegistry();
schreg.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
// Add SSL here if you need it
MeasuringClientConnManager conman = new MeasuringClientConnManager(params, schreg);
DefaultHttpClient client = new DefaultHttpClient(conman, params);
client.execute(new HttpGet("http://www.google.com"));
System.out.println(conman.getSentBytes());
System.out.println(conman.getReceivedBytes());