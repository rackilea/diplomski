@Provider
public class MyExceptionMapper implements
        ExceptionMapper<Throwable> {

    @Override
    public Response toResponse(Throwable ex) {

        System.out.println(ex);
        return Response.status(500).build();
    }
}