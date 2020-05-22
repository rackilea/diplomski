@Provider
public class ExceptionHandler implements ExceptionMapper<Throwable> {
    @Override
    public Response toResponse(Throwable exception) {

        System.out.println("Exception type:" + exception.getClass().getCanonicalName());

        exception.printStackTrace();
         if (exception instanceof BadRequestException) {

            return Response.status(Response.Status.BAD_REQUEST)
                    .header("unexpected request data", "BadRequestExceptiont").build();

        } 


        return Response.status(Response.Status.REQUEST_TIMEOUT).header("Problemo", "yes problemo").build();
    }

}