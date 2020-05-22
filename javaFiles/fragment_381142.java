@Provider
public class MySqlIntegrityMapper
    implements ExceptionMapper<MySQLIntegrityConstraintViolationException> {

    @Override
    public Response toResponse(MySQLIntegrityConstraintViolationException ex) {
        return ...;
    }
}