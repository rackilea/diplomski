@Provider
public class SqlExceptionMapper implements ExceptionMapper<SQLException> {

    @Override
    public Response toResponse(SQLException ex) {
        return ...;
    }
}