protected ResponseEntity<byte[]> passthru(HttpServletRequest request, HttpEntity<byte[]> entity,
                Map<String, Object> model) throws Exception {

    String path = extractPath(request);

    HttpHeaders requestHeaders = new HttpHeaders();
    requestHeaders.putAll(getRequestHeaders(entity.getHeaders()));
    requestHeaders.remove(COOKIE);
    requestHeaders.remove(COOKIE.toLowerCase());
    // Get back end cookie if saved in session
    String cookie = (String) model.get(COOKIE_MODEL);
    if (cookie != null) {
        logger.debug("Found back end cookies: " + cookie);
        for (String value : cookie.split(";")) {
            requestHeaders.add(COOKIE, value);
        }
    }

    ResponseEntity<byte[]> response = defaultTemplate.exchange(getUaaBaseUrl() + "/" + path,
                    HttpMethod.valueOf(request.getMethod()), new HttpEntity<byte[]>(entity.getBody(),
                                    requestHeaders),
                    byte[].class);
    HttpHeaders outgoingHeaders = getResponseHeaders(response.getHeaders());
    return new ResponseEntity<byte[]>(response.getBody(), outgoingHeaders, response.getStatusCode());

}