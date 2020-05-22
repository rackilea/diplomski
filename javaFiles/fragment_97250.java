public class CORSFilter implements ContainerResponseFilter {

    public ContainerResponse filter(ContainerRequest req, ContainerResponse containerResponse) {

        ResponseBuilder responseBuilder = Response.fromResponse(containerResponse.getResponse());

        // *(allow from all servers) OR http://example.com/
        responseBuilder.header("Access-Control-Allow-Origin", "*")

        // As a part of the response to a request, which HTTP methods can be used during the actual request.
        .header("Access-Control-Allow-Methods", "API, CRUNCHIFYGET, GET, POST, PUT, UPDATE, OPTIONS")

        // How long the results of a request can be cached in a result    cache.
        .header("Access-Control-Max-Age", "151200")

        // As part of the response to a request, which HTTP headers can be used during the actual request.
        .header("Access-Control-Allow-Headers", "x-requested-with,Content-Type");

        String requestHeader = req.getHeaderValue("Access-Control-Request-Headers");

        if (null != requestHeader && !requestHeader.equals(null)) {
            responseBuilder.header("Access-Control-Allow-Headers", requestHeader);
        }

        containerResponse.setResponse(responseBuilder.build());
        return containerResponse;
    }
}