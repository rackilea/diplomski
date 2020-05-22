/*
 * Faults
 */

public final boolean hasFault() throws IOException {
    return HttpTransportConstants.STATUS_INTERNAL_SERVER_ERROR == getResponseCode() && isXmlResponse();
}

/** Determine whether the response is a XML message. */
private boolean isXmlResponse() throws IOException {
    Iterator<String> iterator = getResponseHeaders(HttpTransportConstants.HEADER_CONTENT_TYPE);
    if (iterator.hasNext()) {
        String contentType = iterator.next().toLowerCase();
        return contentType.indexOf("xml") != -1;
    }
    return false;
}