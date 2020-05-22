import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

public class NoRoomApplicationFoundException extends WebApplicationException {

    private static final long serialVersionUID = 1L;

    public NoRoomApplicationFoundException() {
        this("Room not found", 400);
    }

    public NoRoomApplicationFoundException(String msg, int status) {
        this(Response.status(status).entity(msg).build());
    }

    public NoRoomApplicationFoundException(Response response) {
        super(response);
    }
}