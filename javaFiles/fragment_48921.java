SOAPConnection connection = SOAPConnectionFactory.newInstance().createConnection();
URL endpoint =
  new URL(new URL("http://yourserver.yourdomain.com/"),
          "/path/to/webservice",
          new URLStreamHandler() {
            @Override
            protected URLConnection openConnection(URL url) throws IOException {
              URL target = new URL(url.toString());
              URLConnection connection = target.openConnection();
              // Connection settings
              connection.setConnectTimeout(10000); // 10 sec
              connection.setReadTimeout(60000); // 1 min
              return(connection);
            }
          });

SOAPMessage result = connection.call(soapMessage, endpoint);