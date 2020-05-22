private String createRequest(String url) { // Is there a problem with this request? 
    String request = "GET " + "/ " + "HTTP/1.1\r\n";
    request += "Host: www.cs.usfca.edu\n";
    request += "\r\n";
    return request;
}