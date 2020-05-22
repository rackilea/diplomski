HttpPost request = new HttpPost("http://google.com/Service1.asmx/GetFuelStops");

// Add your data
List<NameValuePair> nvps = new ArrayList<NameValuePair>(2);
nvps.add(new BasicNameValuePair("skip", "10"));
nvps.add(new BasicNameValuePair("take", "10"));
request.setEntity(new UrlEncodedFormEntity(nvps));