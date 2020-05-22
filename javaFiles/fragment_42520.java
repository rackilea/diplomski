public class OAuth2MockMvcHelper extends MockMvcHelper {
    public static final String VALID_TEST_TOKEN_VALUE = "test.fake.jwt";

    public OAuth2MockMvcHelper(
            final MockMvc mockMvc,
            final ObjectFactory<HttpMessageConverters> messageConverters,
            final MediaType defaultMediaType) {
        super(mockMvc, messageConverters, defaultMediaType);
    }

    /**
     * Adds OAuth2 support: adds an Authorisation header to all request builders
     * if there is an OAuth2Authentication in test security context.
     * 
     * /!\ Make sure your token services recognize this dummy "VALID_TEST_TOKEN_VALUE" token as valid during your tests /!\
     *
     * @param contentType should be not-null when issuing request with body (POST, PUT, PATCH), null otherwise
     * @param accept      should be not-null when issuing response with body (GET, POST, OPTION), null otherwise
     * @param method
     * @param urlTemplate
     * @param uriVars
     * @return a request builder with minimal info you can tweak further (add headers, cookies, etc.)
     */
    @Override
    public MockHttpServletRequestBuilder requestBuilder(
            Optional<MediaType> contentType,
            Optional<MediaType> accept,
            HttpMethod method,
            String urlTemplate,
            Object... uriVars) {
        final MockHttpServletRequestBuilder builder = super.requestBuilder(contentType, accept, method, urlTemplate, uriVars);
        if (SecurityContextHolder.getContext().getAuthentication() instanceof OAuth2Authentication) {
            builder.header("Authorization", "Bearer " + VALID_TEST_TOKEN_VALUE);
        }
        return builder;
    }
}