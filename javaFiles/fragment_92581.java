public boolean test(int count, int maXResult) {
 if ( count > maxResults) {
        // Send error response
        sendResponse(XMLHelper.buildErrorXMLString("Too many results found, Please refine your search"), out, session);
        return true;
        }
return false;
}