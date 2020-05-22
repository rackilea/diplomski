String s = "HTTP/1.1 200 OK\r\n" +
        "Content-Length: 100\r\n" +
        "Content-Type: text/plain\r\n" +
        "Server: some-server\r\n" +
        "\r\n";
SessionInputBufferImpl sessionInputBuffer = new SessionInputBufferImpl(new HttpTransportMetricsImpl(), 2048);
sessionInputBuffer.bind(new ByteArrayInputStream(s.getBytes(Consts.ASCII)));
DefaultHttpResponseParser responseParser = new DefaultHttpResponseParser(sessionInputBuffer);
HttpResponse response = responseParser.parse();
System.out.println(response);