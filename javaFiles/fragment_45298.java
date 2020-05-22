setHeader("http://www.w3.org/2005/08/addressing", "To",  "http://WSDL.URL");
    setHeader("http://www.w3.org/2005/08/addressing", "Action",  "http://tempuri.org/foo/bar");

    SOAPHeaderElement[]  headers = getHeaders();
    for (SOAPHeaderElement h : headers) { h.setRole(null); }

    setRequestHeaders(_call);
    setAttachments(_call);