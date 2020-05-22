BasicHttpParams params = new BasicHttpParams();
SchemeRegistry schreg = new SchemeRegistry();
schreg.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
// Add SSL here if you need it
MeasuringClientConnManager conman = new MeasuringClientConnManager(params, schreg);
conman.setWireListener(new MeasuringClientConnManager.WireListener() {
    @Override
    public void onUpdate(long sent, long recv) {
        System.out.println("WIRE sent: " + sent + ", recv: " + recv);
    }
});
DefaultHttpClient client = new DefaultHttpClient(conman, params);
client.execute(new HttpGet("http://www.thirdbase.se"));