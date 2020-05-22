import com.google.inject.Singleton;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
@Singleton
public class MyExceptionMapper implements ExceptionMapper<MyException>
{
   @Override
   public Response toResponse(final MyException exception)
   {
      return Response.status(Status.NOT_FOUND).entity(exception.getMessage()).build();
   }
}