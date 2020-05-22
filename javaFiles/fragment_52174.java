import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class NotFoundExceptionMapper
        implements ExceptionMapper<NotFoundException> {
    final String html
            = "<p style='font-size:20px;font-family:Sans-serif'>"
            + "Service is unavailable message."
            + "</p>"
            + "<a href='http://www.stackoverflow.com'>"
            + "Check out Stackoverflow</a>";

    @Override
    public Response toResponse(NotFoundException e) {
        return Response.status(Status.NOT_FOUND)
                .entity(html).build();
    }
}