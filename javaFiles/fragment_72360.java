SslSession sslSession = 
    (SslSession) HttpServletRequest.getAttribute(
        "org.eclipse.jetty.servlet.request.ssl_session");
System.out.println("protocol is " + sslSession.getProtocol());
System.out.println("cipher suite is " + sslSession.getCipherSuite());
System.out.println("peer certs is " + sslSession.getPeerCertificates());