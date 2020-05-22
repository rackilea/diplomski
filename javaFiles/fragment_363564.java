public class MyExceptionMapper implements 
     ExceptionMapper<WebApplicationException> {

    @Context
    private HttpServletRequest servletRequest;

    @Override
    public Response toResponse(WebApplicationException error) {

        Response response = error.getResponse();
        ErrorResponse errorResponse = ErrorResponseBuilder
                .builder()
                .httpStatus(getDefaultStatusCodeIfNull(response))
                .errorMessage(getCustomErrorMessage(response))
                .requestedUri(servletRequest.getRequestURI())
                .build();

        return Response
               .status(errorResponse.getHttpStatus())
               .type(ExtendedMediaType.APPLICATION_JSON)
               .entity(errorResponse)
               .build();
    }
}