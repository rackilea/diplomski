/**
 * Wraps MockMvc to further ease interaction with tested API:
 * provides with:<ul>
 * <li>many request shortcuts for simple cases (see get, post, put, patch, delete methods)</li>
 * <li>perfom method along with request builder initialisation shortcuts (see getRequestBuilder, etc.) when more control is required (additional headers, ...)</li>
 * </ul>
 */
public class MockMvcHelper {

    private final MockMvc mockMvc;

    private final MediaType defaultMediaType;

    protected final SerializationHelper conv;

    public MockMvcHelper(MockMvc mockMvc, ObjectFactory<HttpMessageConverters> messageConverters, MediaType defaultMediaType) {
        this.mockMvc = mockMvc;
        this.conv = new SerializationHelper(messageConverters);
        this.defaultMediaType = defaultMediaType;
    }

    /**
     * Generic request builder which adds relevant "Accept" and "Content-Type" headers
     *
     * @param contentType should be not-null when issuing request with body (POST, PUT, PATCH), null otherwise
     * @param accept      should be not-null when issuing response with body (GET, POST, OPTION), null otherwise
     * @param method
     * @param urlTemplate
     * @param uriVars
     * @return a request builder with minimal info you can tweak further: add headers, cookies, etc.
     */
    public MockHttpServletRequestBuilder requestBuilder(
            Optional<MediaType> contentType,
            Optional<MediaType> accept,
            HttpMethod method,
            String urlTemplate,
            Object... uriVars) {
        final MockHttpServletRequestBuilder builder = request(method, urlTemplate, uriVars);
        contentType.ifPresent(builder::contentType);
        accept.ifPresent(builder::accept);
        return builder;
    }

    public ResultActions perform(MockHttpServletRequestBuilder request) throws Exception {
        return mockMvc.perform(request);
    }

    /* GET */
    public MockHttpServletRequestBuilder getRequestBuilder(MediaType accept, String urlTemplate, Object... uriVars) {
        return requestBuilder(Optional.empty(), Optional.of(accept), HttpMethod.GET, urlTemplate, uriVars);
    }

    public MockHttpServletRequestBuilder getRequestBuilder(String urlTemplate, Object... uriVars) {
        return getRequestBuilder(defaultMediaType, urlTemplate, uriVars);
    }

    public ResultActions get(MediaType accept, String urlTemplate, Object... uriVars) throws Exception {
        return mockMvc.perform(getRequestBuilder(accept, urlTemplate, uriVars));
    }

    public ResultActions get(String urlTemplate, Object... uriVars) throws Exception {
        return mockMvc.perform(getRequestBuilder(urlTemplate, uriVars));
    }

    /* POST */
    public <T> MockHttpServletRequestBuilder postRequestBuilder(final T payload, MediaType contentType, MediaType accept, String urlTemplate, Object... uriVars) throws Exception {
        return feed(
                requestBuilder(Optional.of(contentType), Optional.of(accept), HttpMethod.POST, urlTemplate, uriVars),
                payload,
                contentType);
    }

    public <T> MockHttpServletRequestBuilder postRequestBuilder(final T payload, String urlTemplate, Object... uriVars) throws Exception {
        return postRequestBuilder(payload, defaultMediaType, defaultMediaType, urlTemplate, uriVars);
    }

    public <T> ResultActions post(final T payload, MediaType contentType, MediaType accept, String urlTemplate, Object... uriVars) throws Exception {
        return mockMvc.perform(postRequestBuilder(payload, contentType, accept, urlTemplate, uriVars));
    }

    public <T> ResultActions post(final T payload, String urlTemplate, Object... uriVars) throws Exception {
        return mockMvc.perform(postRequestBuilder(payload, urlTemplate, uriVars));
    }


    /* PUT */
    public <T> MockHttpServletRequestBuilder putRequestBuilder(final T payload, MediaType contentType, String urlTemplate, Object... uriVars) throws Exception {
        return feed(
                requestBuilder(Optional.of(contentType), Optional.empty(), HttpMethod.PUT, urlTemplate, uriVars),
                payload,
                contentType);
    }

    public <T> MockHttpServletRequestBuilder putRequestBuilder(final T payload, String urlTemplate, Object... uriVars) throws Exception {
        return putRequestBuilder(payload, defaultMediaType, urlTemplate, uriVars);
    }

    public <T> ResultActions put(final T payload, MediaType contentType, String urlTemplate, Object... uriVars) throws Exception {
        return mockMvc.perform(putRequestBuilder(payload, contentType, urlTemplate, uriVars));
    }

    public <T> ResultActions put(final T payload, String urlTemplate, Object... uriVars) throws Exception {
        return mockMvc.perform(putRequestBuilder(payload, urlTemplate, uriVars));
    }


    /* PATCH */
    public <T> MockHttpServletRequestBuilder patchRequestBuilder(final T payload, MediaType contentType, String urlTemplate, Object... uriVars) throws Exception {
        return feed(
                requestBuilder(Optional.of(contentType), Optional.empty(), HttpMethod.PATCH, urlTemplate, uriVars),
                payload,
                contentType);
    }

    public <T> MockHttpServletRequestBuilder patchRequestBuilder(final T payload, String urlTemplate, Object... uriVars) throws Exception {
        return patchRequestBuilder(payload, defaultMediaType, urlTemplate, uriVars);
    }

    public <T> ResultActions patch(final T payload, MediaType contentType, String urlTemplate, Object... uriVars) throws Exception {
        return mockMvc.perform(patchRequestBuilder(payload, contentType, urlTemplate, uriVars));
    }

    public <T> ResultActions patch(final T payload, String urlTemplate, Object... uriVars) throws Exception {
        return mockMvc.perform(patchRequestBuilder(payload, urlTemplate, uriVars));
    }


    /* DELETE */
    public MockHttpServletRequestBuilder deleteRequestBuilder(String urlTemplate, Object... uriVars) {
        return requestBuilder(Optional.empty(), Optional.empty(), HttpMethod.DELETE, urlTemplate, uriVars);
    }

    public ResultActions delete(String urlTemplate, Object... uriVars) throws Exception {
        return mockMvc.perform(deleteRequestBuilder(urlTemplate, uriVars));
    }


    /* HEAD */
    public MockHttpServletRequestBuilder headRequestBuilder(String urlTemplate, Object... uriVars) {
        return requestBuilder(Optional.empty(), Optional.empty(), HttpMethod.HEAD, urlTemplate, uriVars);
    }

    public ResultActions head(String urlTemplate, Object... uriVars) throws Exception {
        return mockMvc.perform(headRequestBuilder(urlTemplate, uriVars));
    }


    /* OPTION */
    public MockHttpServletRequestBuilder optionRequestBuilder(MediaType accept, String urlTemplate, Object... uriVars) {
        return requestBuilder(Optional.empty(), Optional.of(accept), HttpMethod.OPTIONS, urlTemplate, uriVars);
    }

    public MockHttpServletRequestBuilder optionRequestBuilder(String urlTemplate, Object... uriVars) {
        return requestBuilder(Optional.empty(), Optional.of(defaultMediaType), HttpMethod.OPTIONS, urlTemplate, uriVars);
    }

    public ResultActions option(MediaType accept, String urlTemplate, Object... uriVars) throws Exception {
        return mockMvc.perform(optionRequestBuilder(accept, urlTemplate, uriVars));
    }

    public ResultActions option(String urlTemplate, Object... uriVars) throws Exception {
        return mockMvc.perform(optionRequestBuilder(urlTemplate, uriVars));
    }

    /**
     * Adds serialized payload to request content
     *
     * @param request
     * @param payload
     * @param mediaType
     * @param <T>
     * @return the request with provided payload as content
     * @throws Exception if things go wrong (no registered serializer for payload type and asked MediaType, serialization failure, ...)
     */
    public <T> MockHttpServletRequestBuilder feed(
            MockHttpServletRequestBuilder request,
            final T payload,
            final MediaType mediaType) throws Exception {
        if (payload == null) {
            return request;
        }

        final SerializationHelper.ByteArrayHttpOutputMessage msg = conv.outputMessage(payload, mediaType);
        return request
                .headers(msg.headers)
                .content(msg.out.toByteArray());
    }
}