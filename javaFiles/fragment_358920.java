protected Invocation.Builder getInvocationBuilder(final String templateUri, final Map<String, Object> templateValues,
        final Map<String, Object> queryParameterValues) {
    final String baseUrl = ApplicationProperties.getInstance().getProperty("ucp.baseUrl");
    final Client client = ClientBuilder.newClient();
    final WebTarget target = client.target(baseUrl);
    final WebTarget template = target.path(templateUri);
    final WebTarget resource = template.resolveTemplates(templateValues);
    if (queryParameterValues != null) {
        final Iterator iterator = queryParameterValues.entrySet().iterator();
        while (iterator.hasNext()) {
            final Map.Entry pair = (Map.Entry) iterator.next();
            resource.queryParam((String) pair.getKey(), pair.getValue());
        }
    }
    final Invocation.Builder invocationBuilder = resource.request(MediaType.APPLICATION_JSON_TYPE);
    return invocationBuilder;
}