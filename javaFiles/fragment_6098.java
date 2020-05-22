public static void main(String... args) {
    int port = 2309;
    sSocket sSocket = new sSocket(port);
    System.out.println("### SERVER IS UP AND RUNNING, WAITING FOR A CLIENT TO CONNECT ON " + port + " ###");
    Socket cSocket = sSocket.accept();
    System.out.println("### CONNECTION WITH THE CLIENT CREATED ###");
    InputStream readRequest = cSocket.getInputStream();
    PrintWriter writeResponse = new PrintWriter(cSocket.getOutputStream());
    byte[] buf = new byte[4096];
    readRequest.read(buf);
    String httpPayload = new String(buf, "UTF-8");
    HttpPayload httpPayloadObject = new HttpPayload(httpPayload);
    Map<String, Object> httpParameters = httpPayloadObject.getHttpPayloadBodyMap();
    PushNotificationEvent event = new PushNotificationEvent(httpParameters);
    event.processEvent();
    writeResponse.write("HTTP/1.0 200 OK\r\n");
    writeResponse.write("Date: Fri, 31 Dec 1999 23:59:59 GMT\r\n");
    writeResponse.write("Server: Apache/0.8.4\r\n");
    writeResponse.write("Content-Type: text/html\r\n");
    writeResponse.write("Content-Length: 59\r\n");
    writeResponse.write("Expires: Sat, 01 Jan 2000 00:59:59 GMT\r\n");
    writeResponse.write("Last-modified: Fri, 09 Aug 1996 14:21:40 GMT\r\n");
    writeResponse.write("\r\n");
    writeResponse.write("<TITLE>Example</TITLE>");
    writeResponse.write("<P>This is an example</P>");
}