public static final String REQUEST_XML          = "<Request>";
    public static final String REQUEST_END_XML      = "</Request>";
    /**
 * @param xmlMessage
 * @return 1-N EncodedRequests for those I contain
 */
private void extractRequests( String xmlMessage ) {
    int start = xmlMessage.indexOf(REQUEST_XML);
    int end = xmlMessage.indexOf(REQUEST_END_XML);
    end += REQUEST_END_XML.length();
    while( start >= 0 ) {   //each <Request>
        requests.add(new EncodedRequest(xmlMessage.substring(start,end)));
        start = xmlMessage.indexOf(REQUEST_XML, end);
        end = xmlMessage.indexOf(REQUEST_END_XML, start);
        end += REQUEST_END_XML.length();
    }
}