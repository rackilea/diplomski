@Interceptor
@ExceptionHandler
public class ExceptionHandlerInterceptor  {

    @AroundInvoke
    public Object processRequest(final InvocationContext invocationContext) {

        try {
            return invocationContext.proceed();

        }
        catch (final WebApplicationException e) {

            final int status = e.getResponse().getStatus();
            final String errorJson = e.getResponse().readEntity(String.class);

            final Jsonb jsonb = JsonbBuilder.create();

            //"ErrorMessageDTO" is waited when a error occurs
            ErrorMessage errorMessage = jsonb.fromJson(errorJson, ErrorMessage.class);

            //isValid method verifies if the conversion was successful
            if(errorMessage.isValid()) {
                return Response
                        .status(status)
                        .entity(errorMessage)
                        .build();
            }

            errorMessage = ErrorMessage
                    .builder()
                    .statusCode(status)
                    .statusMessage(e.getMessage())
                    .success(false)
                    .build();

            return Response
                    .status(status)
                    .entity(errorMessage)
                    .build();
        }
        catch (final Exception e) {

            e.printStackTrace();

            return Response
                    .status(Status.INTERNAL_SERVER_ERROR)
                    .entity(ErrorMessage
                            .builder()
                            .statusCode(Status.INTERNAL_SERVER_ERROR.getStatusCode())
                            .statusMessage(e.getMessage())
                            .success(false)
                            .build())
                    .build();
        }
    }

}