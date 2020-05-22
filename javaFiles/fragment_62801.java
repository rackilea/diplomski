@Context
private HttpServletRequest httpRequest;
@Context
private UriInfo uriInfo;

/**
 * @see org.apache.cxf.jaxrs.ext.ResponseHandler#handleResponse(org.apache.cxf.message.Message, org.apache.cxf.jaxrs.model.OperationResourceInfo, javax.ws.rs.core.Response)
 */
public Response handleResponse(Message message, OperationResourceInfo opResourceInfo, Response response) {
    try {

        // log the injected context data; useful for debugging CXF problems
        logContextData(httpRequest, uriInfo);

        OutputStream os = message.getContent(OutputStream.class);
        String relevantData = getDataFromRequest(httpRequest);
        message.setContent(OutputStream.class, new MyOutputStreamWrapper(os, relevantData));

    } catch (CustomException e) {
            // return some status that is related to CustomException
        return Response.status(Status.UNAUTHORIZED).build();
    } catch (Exception e) {
        return Response.status(Status.INTERNAL_SERVER_ERROR).build();
    }

    return response;
}

/**
 * @see org.apache.cxf.jaxrs.ext.RequestHandler#handleRequest(org.apache.cxf.message.Message, org.apache.cxf.jaxrs.model.ClassResourceInfo)
 */
public Response handleRequest(Message message, ClassResourceInfo classResourceInfo) {
    try {

        // log the injected context data; useful for debugging CXF problems
        logContextData();

        String updatedQueryString = buildNewQueryString(this.uriInfo, httpRequest);

        message.put(Message.QUERY_STRING, updatedQueryString);


        // returning null tells CXF to continue the request (i.e. a non-null value would halt the request)
        return null;

    } catch (CustomException e) {
        // return some status that is related to CustomException
        return Response.status(Status.UNAUTHORIZED).build();
    } catch (Exception e) {
        return Response.status(Status.INTERNAL_SERVER_ERROR).build();
    }
}