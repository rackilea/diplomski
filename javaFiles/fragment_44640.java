public static SOAPMessage sendSOAPMessage(SOAPMessage message, String url, final Proxy p) throws SOAPException, MalformedURLException {
    SOAPConnectionFactory factory = SOAPConnectionFactory.newInstance();
    SOAPConnection connection = factory.createConnection();

    URL endpoint = new URL(null, url, new URLStreamHandler() {
        protected URLConnection openConnection(URL url) throws IOException {
            // The url is the parent of this stream handler, so must
            // create clone
            URL clone = new URL(url.toString());

            URLConnection connection = null;
            if (p.address().toString().equals("0.0.0.0/0.0.0.0:80")) {
                connection = clone.openConnection();
            } else
                connection = clone.openConnection(p);
            connection.setConnectTimeout(5 * 1000); // 5 sec
            connection.setReadTimeout(5 * 1000); // 5 sec
            // Custom header
            connection.addRequestProperty("Developer-Mood", "Happy");
            return connection;
        }
    });

    try {
        SOAPMessage response = connection.call(message, endpoint);
        connection.close();
        return response;
    } catch (Exception e) {
        // Re-try if the connection failed
        SOAPMessage response = connection.call(message, endpoint);
        connection.close();
        return response;
    }
}