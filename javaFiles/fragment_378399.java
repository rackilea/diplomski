@Component
public class ThrowableInterceptor
  implements ExceptionMapper<Throwable>
{
  private static final Logger logger = LoggerFactory.getLogger( ThrowableInterceptor.class );

  @Override
  public Response toResponse( Throwable exception )
  {
   logger.error(
      "Exception with caught", exception );
    ErrorResponse errorResponse = new ErrorResponse(
      ServiceErrorCodes.GENERAL_ERROR.getErrorCode(), "unknown error" );
    return Response.status( Response.Status.INTERNAL_SERVER_ERROR )
      .type( MediaType.APPLICATION_JSON_TYPE )
      .entity( errorResponse )
      .build();
  }
}