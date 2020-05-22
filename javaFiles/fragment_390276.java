URLStreamHandler handler = new sun.net.www.protocol.http.Handler(); //standard http handler
URL url = null;
try {
    url = new URL(null, wsdlUrl, handler); //forced this http handler here
    ws = ServiceUtilityWS.create(url, qName);
} catch (MalformedURLException e) {
}