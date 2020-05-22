List<NameValuePair> qparams = new ArrayList<NameValuePair>();
qparams.add(new BasicNameValuePair("center", "40.714728,-73.998672"));
qparams.add(new BasicNameValuePair("zoom", "12"));
qparams.add(new BasicNameValuePair("size", "400x400"));
qparams.add(new BasicNameValuePair("sensor", "false"));
URI uri = URIUtils.createURI("http", "maps.google.com", -1, "/maps/api/staticmap", 
    URLEncodedUtils.format(qparams, "UTF-8"), null);
HttpGet httpget = new HttpGet(uri);
System.out.println(httpget.getURI());