public class ContentTypeTextToTextJson implements ClientHttpRequestInterceptor {

    private static final Logger LOG = LoggerFactory.getLogger(ContentTypeTextToTextJson.class);

    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution)
            throws IOException {
        LOG.debug("intercepting execution");

        // Get the response as normal.
        ClientHttpResponse response = execution.execute(request, body);
        LOG.debug("intercepted response: " + response);

        // Get the headers.
        HttpHeaders headers = response.getHeaders();
        LOG.debug("response had headers: " + headers);

        // Grab all the content types.
        List<String> contentTypes = headers.get("Content-Type");
        LOG.debug("response had content-types: " + contentTypes);

        // Loop over the content-types.
        for(int i = 0; i < contentTypes.size(); i++) {
            String contentType = contentTypes.get(i);
            LOG.debug("processing content type: " + contentType);
            // I'm not sure if it's possible for a content-type to be null, but I guess it's
            // better safe then sorry?
            if(null == contentType) {
                continue;
            }
            // If it starts with "text;", replace "text" with "text/json" and replace the old content type.
            if(contentType.startsWith("text;")) {
                contentType = contentType.replaceFirst("text", "application/json");
                LOG.debug("replacing content type " + contentTypes.get(i) + " with content type " + contentType);
                contentTypes.set(i, contentType);
            }
        }

        // Return the response.
        return response;
    }

}