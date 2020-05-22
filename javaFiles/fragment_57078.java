@Override 
    public Set<QName> getHeaders() { 
        QName securityHeader = new QName("http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd", 
                "Security"); 
        HashSet<QName> headers = new HashSet<QName>(); 
        headers.add(securityHeader);         
        return headers; 
    }