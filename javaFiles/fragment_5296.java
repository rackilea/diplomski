String originalURI = (String) externalContext.getRequestMap().get(RequestDispatcher.FORWARD_REQUEST_URI);
String originalQuery = (String) externalContext.getRequestMap().get(RequestDispatcher.FORWARD_QUERY_STRING);

if (originalQuery != null) {
    originalURI+= "?" + originalQuery;
}