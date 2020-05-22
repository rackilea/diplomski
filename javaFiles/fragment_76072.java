import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.fasterxml.jackson.core.JsonProcessingException;

@Provider
public class JsonProcessingExceptionMapper implements ExceptionMapper<JsonProcessingException>{

        public static class Error {
            public String key;
            public String message;
        }

        @Override
        public Response toResponse(JsonProcessingException exception) {
            Error error = new Error();
            error.key = "bad-json";
            error.message = exception.getMessage();
            return Response.status(Status.BAD_REQUEST).entity(error).build();
        }
}