public class AuthorizationRequestFilter implements ContainerRequestFilter {
    public void filter(ContainerRequestContext requestContext) throws IOException {

        Message message = JAXRSUtils.getCurrentMessage();
        OperationResourceInfo operation = message.getExchange().get(OperationResourceInfo.class);
        Method m = operation.getMethodToInvoke();
        boolean hasAnnotation =  m.getAnnotation(ReadPermission.class) != null;
    }
}