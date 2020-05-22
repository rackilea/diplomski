@Override
public void filter(ClientRequestContext requestContext, ClientResponseContext responseContext) throws IOException {
    if (responseContext.getStatus() == 500 && responseContext.hasEntity()) {
        Map error = new ObjectMapper().readValue(responseContext.getEntityStream(), Map.class);
        LOG.error("Status: {}, Exception: {}, Message: {}", 
            responseContext.getStatus(), error.get("exception"), error.get("message"));
    }
}