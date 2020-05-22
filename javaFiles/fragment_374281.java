@Provider
public class Mapper extends ExceptionMapper<ConstraintViolationException> {

    @Context
    private ResourceInfo resourceInfo;

    @Override
    public Response toResponse(ConstraintViolationException ex) {
        Method resourceMethod = resourceInfo.getResourceMethod();
        Parameter[] parameters = resourceMethod.getParameters();
    }
}