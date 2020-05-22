private String More ...getSoapAction(HttpServletRequest req) throws AxisFault {

String soapAction = req.getHeader(HTTPConstants.HEADER_SOAP_ACTION);
if (soapAction == null) {
    String contentType = req.getHeader(HTTPConstants.HEADER_CONTENT_TYPE);
    if(contentType != null) {
        int index = contentType.indexOf("action");
        if(index != -1){
            soapAction = contentType.substring(index + 7);
        }
    }
}